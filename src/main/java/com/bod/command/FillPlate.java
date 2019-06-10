package com.bod.command;

import com.bod.entity.Food;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FillPlate implements Command {
    private static final Logger LOG = Logger.getLogger(FillPlate.class);

    @Override
    public String execute(HttpServletRequest req) {
        int foodId = Integer.parseInt(req.getParameter("food_selection"));
        List<Food> foodList = (ArrayList<Food>) req.getAttribute("foodList");
        Map<Food, Float> plate = (HashMap<Food, Float>) req.getAttribute("plate");
        float amount = (float) req.getAttribute("amount");

        LOG.info("Adding " + foodList.get(foodId).getName() + " to plate");
        plate.put(foodList.get(foodId), amount);

        req.setAttribute("plate", plate);

        return "jsp/client_page.jsp";
    }
}
