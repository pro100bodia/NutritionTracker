package com.bod.repository;

import com.bod.entity.Client;
import com.bod.entity.Databaseable;
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
    public int updateEntity(Databaseable entity) throws SQLException {
        Client client = (Client) entity;

        PreparedStatement updateStatement = NutritionConnection.getConnection()
                .prepareStatement("UPDATE clients SET name=?, gender=?, " +
                        "height=?, weight=?, lifestyle=?, img=? WHERE id=?");

        updateStatement.setString(1, client.getName());
        updateStatement.setString(2, client.getGender().name());
        updateStatement.setDouble(3, client.getHeight());
        updateStatement.setDouble(4, client.getWeight());
        updateStatement.setString(5, client.getLifeStyle().name());
        updateStatement.setString(6, client.getImg());
        updateStatement.setInt(7, client.getId());

        return updateStatement.executeUpdate();
    }
}
