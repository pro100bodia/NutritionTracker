package com.bod.repository.specifications;

import com.bod.repository.NutritionConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientReadLoginDataSpecification implements SQLSpecification {
    private String userName;
    private String password;

    public ClientReadLoginDataSpecification(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    @Override
    public PreparedStatement toSqlClauses() throws SQLException {
        PreparedStatement readStatement = NutritionConnection.getConnection()
                .prepareStatement("SELECT id, name, password, role FROM clients WHERE name = ? AND password = ?");

        readStatement.setString(1, userName);
        readStatement.setString(2, password);

        return readStatement;
    }
}
