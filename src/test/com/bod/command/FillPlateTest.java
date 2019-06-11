package com.bod.command;

import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class FillPlateTest {
    @Test
    public void shouldExecute() {
        HttpServletRequest req = mock(HttpServletRequest.class);
        FillPlate fillPlate = mock(FillPlate.class);

        fillPlate.execute(req);
        verify(fillPlate).execute(req);
    }
}