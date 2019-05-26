package com.bod.repository;

import com.bod.repository.specifications.SQLSpecification;

import java.sql.*;

public class ClientRepository implements EntityRepository, UpdateQuery, ReadQuery {
    @Override
    public void createEntity(Object... args) throws SQLException {
        PreparedStatement createStatement = NutritionConnection.getConnection()
                .prepareStatement("INSERT INTO clients VALUES " +
                        "(NULL, ?, ?, ?, ?, ?, ?, ?)");

        createStatement.setString(1, (String) args[0]);
        createStatement.setString(2, (String) args[1]);
        createStatement.setDate(3, (Date) args[2]);
        createStatement.setString(4, (String) args[3]);
        createStatement.setDouble(5, (Double) args[4]);
        createStatement.setDouble(6, (Double) args[5]);
        createStatement.setString(7, (String) args[6]);

        createStatement.execute();

        createStatement.close();
    }

    @Override
    public ResultSet readEntity(int id) throws SQLException {
        PreparedStatement readStatement = NutritionConnection.getConnection()
                .prepareStatement("SELECT * FROM clients WHERE id=?");

        readStatement.setInt(1, id);

        return readStatement.executeQuery();
    }

    @Override
    public void deleteEntity(int id) throws SQLException {
        PreparedStatement readStatement = NutritionConnection.getConnection()
                .prepareStatement("DELETE FROM clients WHERE id=?");

        readStatement.setInt(1, id);

        readStatement.execute();

        readStatement.close();
    }

    @Override
    public ResultSet specificReadQuery(SQLSpecification sqlSpecification) throws SQLException {
        Statement specificReadStatement = NutritionConnection.getConnection().createStatement();

        return sqlSpecification.toSqlClauses().executeQuery();


    }

    @Override
    public int specificUpdateQuery(SQLSpecification sqlSpecification) throws SQLException {
        Statement specificUpdateStatement = NutritionConnection.getConnection().createStatement();

        int result = sqlSpecification.toSqlClauses().executeUpdate();

        specificUpdateStatement.close();

        return result;
    }
}
