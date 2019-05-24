package com.bod.repository.specifications;

import com.bod.entity.Client;

public class ClientUpdateLifeStyleSpecification implements SQLSpecification {
    private Client client;

    public ClientUpdateLifeStyleSpecification(Client client) {
        this.client = client;
    }

    @Override
    public String toSqlClauses() {
        return String.format("UPDATE clients SET lifestyle=%s WHERE id=%d",
                client.getLifeStyle().name(), client.getId());
    }
}