package com.bod.command;

import com.bod.entity.Food;
import com.bod.services.FoodService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class GetFoodList implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        FoodService foodService = new FoodService();
        List<Food> foodList = foodService.getFoodLIst();
        req.getServletContext().setAttribute("foodList", foodList);

        return "jsp/client_page.jsp";
    }
}
