package com.bod.command;

import com.bod.entity.Client;
import com.bod.entity.DailyRation;
import com.bod.entity.Food;
import com.bod.utils.AppUtils;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FillPlate implements Command {
    private static final Logger LOG = Logger.getLogger(FillPlate.class);

    @Override
    public String execute(HttpServletRequest req) {
        int foodId = Integer.parseInt(req.getParameter("food_selection"));
        foodId--;

        List<Food> foodList = (ArrayList<Food>) req.getServletContext()
                .getAttribute("foodList");

        double amount = Double.parseDouble(req.getParameter("amount").trim());

        Client client = AppUtils.getClientFromSession(req);

        DailyRation dailyRation;
        if ((dailyRation = client.getDailyRation()) == null) {
            dailyRation = new DailyRation(new HashMap<>());
            client.setDailyRation(dailyRation);
        }

        Food food = foodList.get(foodId);
        dailyRation.addFood(food, amount);//or through the client

        LOG.info("Outputing the plate: ");
        for (Food foodUnit : dailyRation.getFoodMap().keySet()) {
            LOG.info(foodUnit.getName() + "  amount: " +
                    dailyRation.getFoodMap().get(foodUnit));
        }

        return "<tr>" +
                "<td>" + food.getName() + "</td>" +
                "<td>" + food.getCalories() + "</td>" +
                "<td>" + food.getProtein() + "</td>" +
                "<td>" + food.getFat() + "</td>" +
                "<td>" + food.getCarbohydrates() + "</td>" +
                "<td>" + food.getNumber() + "</td>" +
                "<td>" + amount + "</td>" +
                "</tr>";

    }
}
