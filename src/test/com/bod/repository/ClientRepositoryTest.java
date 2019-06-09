package com.bod.repository;

import com.bod.entity.Client;
import com.bod.entity.Gender;
import com.bod.entity.LifeStyle;
import com.bod.repository.specifications.ClientReadLoginDataSpecification;
import com.bod.services.ClientService;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.Assert.*;

public class ClientRepositoryTest {
    private int id;
    private String userName, password;
    private ClientRepository clientRepository;
    private ResultSet resultSet;
    private ClientService clientService;

    @Before
    public void setUp() throws Exception {
        id = 2;
        userName = "Sasha";
        password = "1111";
        clientRepository = new ClientRepository();
        clientService = new ClientService();
    }

    @Test
    public void shouldReturnNotNullOnReadAllInfo() throws SQLException {
        resultSet = clientRepository.readEntity(id);
        assertNotNull(resultSet);
    }

    @Test
    public void shouldReturnZeroLengthOnReadLoginData() {
        int rows = 0;
        try {
            resultSet = clientRepository.specificReadQuery(
                    new ClientReadLoginDataSpecification(userName, password));
            while (resultSet.next()) {
                rows++;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        assertEquals(0, rows);
    }

    @Test
    public void shouldUpdateRecord() throws SQLException {
        Client client = new Client();
        client.setImg("sample img");
        client.setName("Boris");
        client.setBirthDate(LocalDate.of(1970, 1, 1));
        client.setGender(Gender.F);
        client.setHeight(123.3);
        client.setWeight(24.5);
        client.setLifeStyle(LifeStyle.H);
        client.setId(8);

        int rows = clientRepository.updateEntity(client);
        assertNotEquals(0, rows);

        Client readClient = clientService.getRawData(8);
        readClient.setId(8);

        assertEquals(client, readClient);
    }
}