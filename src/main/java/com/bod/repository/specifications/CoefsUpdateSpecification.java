package com.bod.repository.specifications;

import com.bod.repository.NutritionConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CoefsUpdateSpecification implements SQLSpecification {
    private int id;
    private double forMen, forWomen;

    public CoefsUpdateSpecification(int id, double forMen, double forWomen) {
        this.id = id;
        this.forMen = forMen;
        this.forWomen = forWomen;
    }

    @Override
    public PreparedStatement toSqlClauses() throws SQLException {
        PreparedStatement updateStatement = NutritionConnection.getConnection()
                .prepareStatement("UPDATE coefs SET men=?, women=? WHERE id=?");

        updateStatement.setDouble(1, forMen);
        updateStatement.setDouble(2, forWomen);
        updateStatement.setInt(2, id);

        return updateStatement;
    }
}
