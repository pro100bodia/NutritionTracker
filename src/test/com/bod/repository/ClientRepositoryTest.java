package com.bod.repository;

import com.bod.repository.specifications.ClientReadLoginDataSpecification;
import org.junit.Before;
import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

import static org.junit.Assert.assertEquals;

public class ClientRepositoryTest {
    private String userName, password;
    private ClientRepository clientRepository;

    @Before
    public void setUp() throws Exception {
        userName = "Sasha";
        password = "1111";
        clientRepository = new ClientRepository();
    }

    @Test
    public void shouldReturnZeroLengthOnReadLoginData() {
        ResultSet resultSet;
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