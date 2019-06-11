package com.bod.repository.specifications;

import com.bod.repository.NutritionConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CoefsReadWomensSpecification implements SQLSpecification {
    @Override
    public PreparedStatement toSqlClauses() throws SQLException {
        return NutritionConnection.getConnection()
                .prepareStatement("SELECT women FROM coefs");
    }
}
