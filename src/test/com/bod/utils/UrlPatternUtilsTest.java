package com.bod.utils;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UrlPatternUtilsTest {
    private HttpServletRequest req;

    @Before
    public void setUp() {
        req = mock(HttpServletRequest.class);
        String servletPath = "/nutrition_tracker/client_page?locale=uk";
        when(req.getServletPath()).thenReturn(servletPath);
    }

    @Test
    public void shouldReturnUrlPattern() {
        assertEquals("/client_page", UrlPatternUtils.getUrlPattern(req));

    }
}