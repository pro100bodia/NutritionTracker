package com.bod.repository.specifications;

import com.bod.entity.Client;

public class ClientUpdateHeightSpecification implements SQLSpecification {
    private Client client;

    public ClientUpdateHeightSpecification(Client client) {
        this.client = client;
    }

    @Override
    public String toSqlClauses() {
        return String.format("UPDATE clients SET height=%f WHERE id=%d",
                client.getHeight(), client.getId());
    }
}
