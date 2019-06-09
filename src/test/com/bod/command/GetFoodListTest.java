package com.bod.command;

import com.bod.entity.Food;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class GetFoodListTest {
    @Test
    public void shouldExecute() {
        HttpServletRequest req = mock(HttpServletRequest.class);
        List<Food> foodList = (ArrayList<Food>) mock(ArrayList.class);
//        when(foodList.get(0)).thenReturn(new Food());

        new GetFoodList().execute(req);

        verify(req).setAttribute("foodList", foodList);
    }
}