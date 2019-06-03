package com.bod.repository.specifications;

import com.bod.repository.NutritionConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientReadNormSpecification implements SQLSpecification {
    private int id;

    public ClientReadNormSpecification(int id) {
        this.id = id;
    }

    @Override
    public PreparedStatement toSqlClauses() throws SQLException {
        PreparedStatement readStatement = NutritionConnection.getConnection()
                .prepareStatement("SELECT date_of_birth, gender, height, weight, lifestyle FROM clients WHERE id=%d");

        readStatement.setInt(1, id);

        return readStatement;
    }
}
