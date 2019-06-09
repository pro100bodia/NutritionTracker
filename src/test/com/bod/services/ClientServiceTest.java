package com.bod.services;

import com.bod.entity.Client;
import com.bod.entity.Gender;
import com.bod.entity.LifeStyle;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;

import static org.junit.Assert.*;

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

    @Test
    public void shouldUpdateEntity() {
        Client client = new Client();
        client.setImg("sample img");
        client.setName("Boris");
        client.setBirthDate(LocalDate.of(1970, 1, 1));
        client.setGender(Gender.F);
        client.setHeight(123.3);
        client.setWeight(24.5);
        client.setLifeStyle(LifeStyle.H);
        client.setId(8);

        int rows = clientService.updateClientData(client);

        assertNotEquals(0, rows);
    }
}