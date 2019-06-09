package com.bod.services;

import com.bod.entity.Client;
import com.bod.entity.Gender;
import com.bod.entity.LifeStyle;
import com.bod.repository.ClientRepository;
import com.bod.repository.specifications.ClientReadLoginDataSpecification;
import org.apache.log4j.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientService {
    private static final Logger LOG = Logger.getLogger(ClientService.class);

    public Client getLoginData(String username, String password) {
        ClientRepository clientRepository = new ClientRepository();

        Client client = null;

        try {
            ResultSet clientRes = clientRepository.specificReadQuery(
                    new ClientReadLoginDataSpecification(username, password));

            while (clientRes.next()) {
                client = new Client();
                client.setId(clientRes.getInt(1));
                client.setName(clientRes.getString(2));
                client.setPassword(clientRes.getString(3));
                client.setRole(clientRes.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return client;
    }

    public Client getRawData(int id) {
        ClientRepository clientRepository = new ClientRepository();
        Client client = new Client();

        try {
            ResultSet clientRes = clientRepository.readEntity(id);
            while (clientRes.next()) {
                client.setImg(clientRes.getString(1));
                client.setName(clientRes.getString(2));
                client.setBirthDate(clientRes.getDate(3).toLocalDate());
                client.setGender(Gender.valueOf(clientRes.getString(4)));
                client.setHeight(clientRes.getDouble(5));
                client.setWeight(clientRes.getDouble(6));
                client.setLifeStyle(LifeStyle.valueOf(clientRes.getString(7)));
            }

            return client;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public int updateClientData(Client data) {
        ClientRepository clientRepository = new ClientRepository();

        try {
            int rows = clientRepository.updateEntity(data);
            LOG.info("Client #" + data.getId() + " updated successfully");
        } catch (SQLException e) {
            LOG.error("Failde to update client #" + data.getId() + "\n" + e);
            e.printStackTrace();
        }

        return 0;
    }
}
