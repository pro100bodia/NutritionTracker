package com.bod.facade;

import com.bod.dto.ClientDTO;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClientFacadeTest {

    private int id;
    private ClientDTO client;
    private ClientFacade clientFacade;
    private String name;

    @Before
    public void setUp() throws Exception {
        id = 2;
        name = "Sasha";
        client = new ClientDTO();
        clientFacade = new ClientFacade();
    }

    @Test
    public void shouldReturnTrueClient() {
        client = clientFacade.getData(id);
        assertEquals(name, client.getName());
    }
}