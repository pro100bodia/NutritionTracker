package com.bod.repository;

import com.bod.repository.specifications.SQLSpecification;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientRepository implements EntityRepository, ReadQuery {
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
                .prepareStatement("SELECT img, name, date_of_birth, gender, height, weight, lifestyle FROM clients WHERE id=?");

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
        return sqlSpecification.toSqlClauses().executeQuery();
    }

    @Override
    public int updateEntity(Object... args) throws SQLException {
        PreparedStatement updateStatement = NutritionConnection.getConnection()
                .prepareStatement("UPDATE clients SET name=?, gender=?, " +
                        "height=?, weight=?, lifestyle=?, img=? WHERE id=?");

        updateStatement.setString(1, (String) args[0]);
        updateStatement.setString(2, (String) args[1]);
        updateStatement.setDouble(3, (Double) args[2]);
        updateStatement.setDouble(4, (Double) args[3]);
        updateStatement.setString(5, (String) args[4]);
        updateStatement.setString(6, (String) args[5]);
        updateStatement.setInt(7, (Integer) args[6]);

        return updateStatement.executeUpdate();
    }
}
