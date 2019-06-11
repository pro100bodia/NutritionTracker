package com.bod.utils;

import com.bod.entity.Client;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SecurityUtilsTest {
    private static HttpServletRequest req;
    private static String servletPath;
    private static HttpSession session;
    private static Client client;

    @BeforeClass
    public static void setUp() throws Exception {
        req = mock(HttpServletRequest.class);
        session = mock(HttpSession.class);
        when(req.getSession()).thenReturn(session);
        client = new Client();
    }

    @Test
    public void shouldReturnTrueOnClientSecurityPage() {
        servletPath = "/client_page";
        when(req.getServletPath()).thenReturn(servletPath);

        assertTrue(SecurityUtils.isSecurityPage(req));
    }

    @Test
    public void shouldReturnTrueOnDoctorSecurityPage() {
        servletPath = "/nutrition_tracker/doctor_page?locale=uk";
        when(req.getServletPath()).thenReturn(servletPath);

        assertTrue(SecurityUtils.isSecurityPage(req));
    }

    @Test
    public void shouldPermitDoctorForDoctor() {
        client.setRole("D");
        when(session.getAttribute("client")).thenReturn(client);

        servletPath = "/nutrition_tracker/doctor_page?locale=uk";
        when(req.getServletPath()).thenReturn(servletPath);

        assertTrue(SecurityUtils.hasPermission(req));

    }

    @Test
    public void shouldPermitClientForDoctor() {
        client.setRole("D");
        when(session.getAttribute("client")).thenReturn(client);

        servletPath = "/nutrition_tracker/client_page?locale=uk";
        when(req.getServletPath()).thenReturn(servletPath);

        assertTrue(SecurityUtils.hasPermission(req));
    }

    @Test
    public void shouldPermitClientToClient() {
        client.setRole("C");
        when(session.getAttribute("client")).thenReturn(client);

        servletPath = "/nutrition_tracker/client_page?locale=uk";
        when(req.getServletPath()).thenReturn(servletPath);

        assertTrue(SecurityUtils.hasPermission(req));
    }
}