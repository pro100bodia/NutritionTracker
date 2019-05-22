package com.bod.repository;

import com.bod.entity.Client;

public class ClientUpdateLifestyleSpecification implements SQLSpecification {
    private Client client;

    public ClientUpdateLifestyleSpecification(Client client) {
        this.client = client;
    }

    @Override
    public String toSqlClauses() {
        return String.format("UPDATE clients SET lifestyle=%s WHERE id=%d",
                client.getLifeStyle().name(), client.getId());
    }
}