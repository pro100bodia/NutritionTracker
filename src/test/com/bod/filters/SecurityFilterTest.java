package com.bod.filters;

import com.bod.entity.Client;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class SecurityFilterTest {
    private static HttpServletRequest req;
    private static SecurityFilter securityFilter;
    private static HttpServletResponse resp;
    private static FilterChain filterChain;

    @BeforeClass
    public static void init() {
        req = mock(HttpServletRequest.class);
        resp = mock(HttpServletResponse.class);
        filterChain = mock(FilterChain.class);
        securityFilter = new SecurityFilter();
        when(req.getServletPath()).thenReturn("/client_page");
    }

    @Test
    public void shouldFailWithoutClient() throws IOException, ServletException {
        securityFilter.doFilter(req, resp, filterChain);

        verify(resp).sendRedirect("/nutrition_tracker/jsp/errors/403.jsp");
    }

    @Test
    public void shouldFailWithClientOnDoctorPage() throws IOException, ServletException {
        HttpSession session = mock(HttpSession.class);
        when(req.getSession()).thenReturn(session);

        Client client = new Client();
        client.setRole("C");

        when(session.getAttribute("client")).thenReturn(client);
        when(req.getServletPath()).thenReturn("/doctor_page");

        securityFilter.doFilter(req, resp, filterChain);

        verify(resp).sendRedirect("/nutrition_tracker/jsp/errors/403.jsp");
    }
}