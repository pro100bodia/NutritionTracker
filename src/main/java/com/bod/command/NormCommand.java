package com.bod.command;

import com.bod.entity.*;
import com.bod.facade.ClientFacade;
import com.bod.facade.DailyFacade;
import com.bod.facade.DeflectionFacade;
import com.bod.services.CoefsService;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class NormCommand implements Command {
    private static final Logger LOG = Logger.getLogger(NormCommand.class);

    @Override
    public String execute(HttpServletRequest req) {
        Client client = (Client) req.getSession().getAttribute("client");

        LOG.info("Calculating eaten nutritive value");
        DailyRation dailyRation = client.getDailyRation();
        double calories = 0.0, proteins = 0.0, fats = 0.0, carbohydrates = 0.0;
        for (Food food : dailyRation.getFoodMap().keySet()) {
            calories += food.getCalories();
            proteins += food.getProtein();
            fats += food.getFat();
            carbohydrates += food.getCarbohydrates();
        }
        NutritiveValue eaten = new NutritiveValue(calories, proteins, fats,
                carbohydrates);
        LOG.info("Daily nutritive value is: " + eaten);

        LOG.info("Calculating client`s norm");
        LOG.info("Getting coefs from database");
        double[] coefs = new CoefsService().getCoefs(client.getGender());

        LifeStyle lifeStyle = new ClientFacade().cacheLifeStyle(
                (String) req.getServletContext().getAttribute("lifeStyle"));

        calories = (coefs[0] + coefs[1] * (Double) req.getServletContext().getAttribute("weight") +
                coefs[2] * (Double) req.getServletContext().getAttribute("height") +
                coefs[3] * (Integer) req.getServletContext().getAttribute("age")) *
                lifeStyle.getValue();

        proteins = carbohydrates = calories / 4;
        fats = calories / 9;

        NutritiveValue norm = new NutritiveValue(calories, proteins, fats, carbohydrates);

        NutritiveValue deflection = eaten.subtract(norm);

        //write deflection
        DeflectionFacade deflectionFacade = new DeflectionFacade();
        deflectionFacade.writeDeflection(deflection, client.getId());

        //writing the plate
        DailyFacade dailyFacade = new DailyFacade();
        dailyFacade.writeToFoodHistory(dailyRation, client.getId());
        //cleaning the plate
        dailyRation.getFoodMap().clear();
        LOG.info("Client`s plate size in the end: " + client.getDailyRation().getFoodMap().size());

        return "<td>" + deflection.getCalories() + "</td>" +
                "<td>" + deflection.getProtein() + "</td>" +
                "<td>" + deflection.getFat() + "</td>" +
                "<td>" + deflection.getCarbohydrates() + "</td>";
    }
}
