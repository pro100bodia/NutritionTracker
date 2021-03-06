package com.bod.repository;

import com.bod.repository.specifications.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CoefsRepository implements EntityRepository, ReadQuery {

    @Override
    public void createEntity(Object... args) throws SQLException {
        PreparedStatement createStatement = NutritionConnection.getConnection()
                .prepareStatement("INSERT INTO coefs VALUES(?, ?, ?)");

        createStatement.setInt(1, (Integer) args[0]);
        createStatement.setDouble(1, (Double) args[1]);
        createStatement.setDouble(1, (Double) args[2]);

        createStatement.execute();

        createStatement.close();
    }

    @Override
    public ResultSet readEntity(int id) throws SQLException {
        PreparedStatement readStatement = NutritionConnection.getConnection().prepareStatement("SELECT * FROM coefs WHERE id = ?");
        readStatement.setInt(1, id);
        return readStatement.executeQuery();
    }

    @Override
    public void deleteEntity(int id) throws SQLException {
        PreparedStatement deleteStatement = NutritionConnection.getConnection().prepareStatement("DELETE FROM coefs WHERE id=?");
        deleteStatement.setInt(1, id);
        deleteStatement.execute();
        deleteStatement.close();
    }

    @Override
    public int updateEntity(Object... args) throws SQLException {
        return 0;
    }

    @Override
    public ResultSet specificReadQuery(SQLSpecification sqlSpecification) throws SQLException {
        return sqlSpecification.toSqlClauses().executeQuery();
    }
}