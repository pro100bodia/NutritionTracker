package com.bod.repository.specifications;

import com.bod.repository.NutritionConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientUpdateWeightSpecification implements SQLSpecification {
    private double weight;
    private int id;

    public ClientUpdateWeightSpecification(double weight, int id) {
        this.weight = weight;
        this.id = id;
    }

    @Override
    public PreparedStatement toSqlClauses() throws SQLException {
        PreparedStatement updateStatement = NutritionConnection.getConnection()
                .prepareStatement("UPDATE clients SET weight=? WHERE id=?");

        updateStatement.setDouble(1, weight);
        updateStatement.setDouble(2, id);

        return updateStatement;
    }
}
