package com.bod.services;

import com.bod.entity.Client;
import com.bod.entity.Gender;
import com.bod.entity.LifeStyle;
import com.bod.repository.ClientRepository;
import com.bod.repository.EntityRepository;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientService {
    private int id;
    private EntityRepository clientRepository = new ClientRepository();

    public ClientService(int id) {
        this.id = id;
    }

    public Client getRawData() {
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
}
