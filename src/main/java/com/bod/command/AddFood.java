package com.bod.command;

import com.bod.entity.Food;
import com.bod.entity.FoodBuilder;
import com.bod.services.FoodService;

import javax.servlet.http.HttpServletRequest;

public class AddFood implements Command {
    @Override
    public String execute(HttpServletRequest req) {
        FoodBuilder builder = new FoodBuilder();
        builder.reset();
        builder.setName(req.getParameter("food_name"));
        builder.setNumber((int) Double.parseDouble(req.getParameter("food_number")));
        builder.setCalories(Double.parseDouble(req.getParameter("food_calories")));
        builder.setProteins(Double.parseDouble(req.getParameter("food_proteins")));
        builder.setFats(Double.parseDouble(req.getParameter("food_fats")));
        builder.setCarbohydrates(Double.parseDouble(req.getParameter("food_carbohydrates")));

        Food food = builder.getResult();

        FoodService service = new FoodService();
        service.addFood(food);

        return "jsp/custom_food.jsp";
    }
}
