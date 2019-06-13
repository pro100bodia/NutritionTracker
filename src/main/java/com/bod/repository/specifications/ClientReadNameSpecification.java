package com.bod.repository.specifications;

import com.bod.repository.NutritionConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientReadNameSpecification implements SQLSpecification {
    private int id;

    public ClientReadNameSpecification(int id) {
        this.id = id;
    }

    @Override
    public PreparedStatement toSqlClauses() throws SQLException {
        PreparedStatement readNameStatement = NutritionConnection.getConnection()
                .prepareStatement("SELECT name FROM clients WHERE id=?");

        readNameStatement.setInt(1, id);

        return readNameStatement;
    }
}
