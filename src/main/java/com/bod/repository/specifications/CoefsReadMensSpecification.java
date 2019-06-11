package com.bod.repository.specifications;

import com.bod.repository.NutritionConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CoefsReadMensSpecification implements SQLSpecification {
    @Override
    public PreparedStatement toSqlClauses() throws SQLException {
        return NutritionConnection.getConnection()
                .prepareStatement("SELECT men FROM coefs");
    }
}
