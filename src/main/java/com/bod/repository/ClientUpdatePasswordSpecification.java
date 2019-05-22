package com.bod.repository;

import com.bod.entity.Client;

public class ClientUpdatePasswordSpecification implements SQLSpecification {
    private Client client;

    public ClientUpdatePasswordSpecification(Client client) {
        this.client = client;
    }

    @Override
    public String toSqlClauses() {
        return String.format("UPDATE clients SET password=%s WHERE id=%d",
                client.getPassword(), client.getId());
    }
}
