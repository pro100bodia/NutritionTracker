package com.bod.utils;

import com.bod.entity.Client;
import org.junit.Before;
import org.junit.Test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AppUtilsTest {
    private HttpServletRequest mockedReq;
    private HttpSession mockedSession;
    private Client client;

    @Before
    public void setUp() throws Exception {
        mockedReq = mock(HttpServletRequest.class);
        mockedSession = mock(HttpSession.class);

        client = new Client();
        client.setId(1);
        client.setName("Bohdan");
        client.setPassword("1111");
        client.setRole("C");

        when(mockedReq.getSession()).thenReturn(mockedSession);
        when(mockedSession.getAttribute("client")).thenReturn(client);

    }

    @Test
    public void shouldGetClientFromSession() {
        assertEquals(client, AppUtils.getClientFromSession(mockedReq));
    }
}