package com.bod.repository.specifications;

import com.bod.repository.NutritionConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientUpdateHeightSpecification implements SQLSpecification {
    double height;

    public ClientUpdateHeightSpecification(double height) {
        this.height = height;
    }

    @Override
    public PreparedStatement toSqlClauses() throws SQLException {
        PreparedStatement updateStatement = NutritionConnection.getConnection()
                .prepareStatement("UPDATE clients SET height=? WHERE id=?");

        updateStatement.setDouble(1, height);

        return updateStatement;
    }
}
