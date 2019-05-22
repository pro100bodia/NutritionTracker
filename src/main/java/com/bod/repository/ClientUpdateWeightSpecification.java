package com.bod.repository;

import com.bod.entity.Client;

public class ClientUpdateWeightSpecification implements SQLSpecification {
    private Client client;

    public ClientUpdateWeightSpecification(Client client) {
        this.client = client;
    }

    @Override
    public String toSqlClauses() {
        return String.format("UPDATE clients SET weight=%f WHERE id=%d",
                client.getWeight(), client.getId());
    }
}
