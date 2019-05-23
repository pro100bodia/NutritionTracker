package com.bod.repository.specifications;

import com.bod.entity.Client;

public class ClientReadBirthDateSpecification implements SQLSpecification {
    private Client client;

    public ClientReadBirthDateSpecification(Client client) {
        this.client = client;
    }

    @Override
    public String toSqlClauses() {
        return String.format("SELECT date_of_birth FROM clients WHERE id=%d",
                client.getId());
    }
}
