package com.bod.command;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

public class GenerateClientDataTest {

    private HttpServletRequest req;
    private int id;
    private String url;
    private GenerateClientData generateClientData;

    @Before
    public void setUp() throws Exception {
        req = mock(HttpServletRequest.class);
        id = 2;
        url = "jsp/client_page.jsp";
        generateClientData = new GenerateClientData();
    }

    @Test
    public void shouldReturnTrueUrl() {
        String testUrl = generateClientData.execute(req, id);
        assertEquals(url, testUrl);
    }
}