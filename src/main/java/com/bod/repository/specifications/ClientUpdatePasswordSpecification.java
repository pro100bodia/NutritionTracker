package com.bod.repository.specifications;

import com.bod.repository.NutritionConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientUpdatePasswordSpecification implements SQLSpecification {
    private String password;
    private int id;

    public ClientUpdatePasswordSpecification(String password, int id) {
        this.password = password;
        this.id = id;
    }

    @Override
    public PreparedStatement toSqlClauses() throws SQLException {
        PreparedStatement updateStatement = NutritionConnection.getConnection()
                .prepareStatement("UPDATE clients SET password=? WHERE id=?");

        updateStatement.setString(1, password);
        updateStatement.setInt(2, id);

        return updateStatement;
    }
}
