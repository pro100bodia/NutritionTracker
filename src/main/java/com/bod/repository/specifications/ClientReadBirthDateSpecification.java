package com.bod.repository.specifications;

import com.bod.repository.NutritionConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientReadBirthDateSpecification implements SQLSpecification {
    private int id;

    public ClientReadBirthDateSpecification(int id) {
        this.id = id;
    }

    @Override
    public PreparedStatement toSqlClauses() throws SQLException {
        PreparedStatement readStatement = NutritionConnection.getConnection()
                .prepareStatement("SELECT date_of_birth FROM clients WHERE id=?");

        readStatement.setInt(1, id);

        return readStatement;
    }
}