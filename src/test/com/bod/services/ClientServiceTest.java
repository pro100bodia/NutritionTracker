package com.bod.services;

import com.bod.entity.Client;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNull;

public class ClientServiceTest {
    private String username, password;
    private ClientService clientService;

    @Before
    public void setUp() throws Exception {
        username = "Sasha";
        password = "1111";
        clientService = new ClientService();
    }

    @Test
    public void shouldReturnNullOnLogin() {
        Client client = clientService.getLoginData(username, password);
        assertNull(client);
    }
}