package com.bod.services;

import com.bod.entity.Client;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class ClientServiceTest {
    private String username, password;
    private ClientService clientService;
    private Client client;
    private int id;

    @Before
    public void setUp() throws Exception {
        id = 2;
        username = "Sasha";
        password = "1111";
        client = new Client();
        clientService = new ClientService();
    }

    @Test
    public void shouldReturnTrueClientOnGetRawData() {
        client = clientService.getRawData(id);
        assertEquals(username, client.getName());
    }

    @Test
    public void shouldReturnNullOnLogin() {
        Client client = clientService.getLoginData(username, password);
        assertNull(client);
    }
}