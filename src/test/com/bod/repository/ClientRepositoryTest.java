package com.bod.repository;

import com.bod.repository.specifications.ClientReadLoginDataSpecification;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ClientRepositoryTest {
    private int id;
    private String userName, password;
    private ClientRepository clientRepository;
    private ResultSet resultSet;

    @Before
    public void setUp() throws Exception {
        id = 2;
        userName = "Sasha";
        password = "1111";
        clientRepository = new ClientRepository();
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
}