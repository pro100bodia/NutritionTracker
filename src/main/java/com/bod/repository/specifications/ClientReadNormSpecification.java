package com.bod.repository.specifications;

import com.bod.entity.Client;

public class ClientReadNormSpecification implements SQLSpecification {
    private Client client;

    public ClientReadNormSpecification(Client client) {
        this.client = client;
    }

    @Override
    public String toSqlClauses() {
        return String.format("SELECT date_of_birth, gender, height, weight, lifestyle FROM clients WHERE id=%d",
                client.getId());
    }
}
