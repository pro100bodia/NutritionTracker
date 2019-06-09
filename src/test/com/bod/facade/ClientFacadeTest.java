package com.bod.facade;

import com.bod.dto.ClientDTO;
import com.bod.entity.Gender;
import com.bod.entity.LifeStyle;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

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

    @Test
    public void shouldUpdateClientData() {
        ClientDTO clientDTO = new ClientDTO();

        clientDTO.setName("Boris");
        clientDTO.setGender(Gender.F.name());
        clientDTO.setHeight(123.3);
        clientDTO.setWeight(23.3);
        clientDTO.setLifeStyle(LifeStyle.E.name());
        clientDTO.setId(8);

        int rows = clientFacade.updateClientData(clientDTO);

        assertNotEquals(0, rows);
    }
}