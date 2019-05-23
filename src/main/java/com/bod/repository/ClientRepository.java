package com.bod.repository;

import com.bod.entity.Client;
import com.bod.repository.specifications.SQLSpecification;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClientRepository implements EntityRepository, UpdateQuery, ReadQuery {
    private Client client;

    public ClientRepository(Client client) {
        this.client = client;
    }

    @Override
    public void createEntity() throws SQLException {
        PreparedStatement createStatement = NutritionConnection.connection
                .prepareStatement("INSERT INTO clients VALUES " +
                        "(NULL, ?, ?, ?, ?, ?, ?, ?)");

        createStatement.setString(1, client.getName());
        createStatement.setString(2, client.getPassword());
        createStatement.setDate(3, java.sql.Date.valueOf(client.getBirthDate()));
        createStatement.setString(4, client.getGender().name());
        createStatement.setDouble(5, client.getHeight());
        createStatement.setDouble(6, client.getWeight());
        createStatement.setString(7, client.getLifeStyle().name());

        createStatement.execute();

        createStatement.close();
    }

    @Override
    public ResultSet readEntity() throws SQLException {
        PreparedStatement readStatement = NutritionConnection.connection
                .prepareStatement("SELECT * FROM clients WHERE id=?");

        readStatement.setInt(1, client.getId());

        return readStatement.executeQuery();
    }

    @Override
    public void deleteEntity() throws SQLException {
        PreparedStatement readStatement = NutritionConnection.connection
                .prepareStatement("DELETE FROM clients WHERE id=?");

        readStatement.setInt(1, client.getId());

        readStatement.execute();

        readStatement.close();
    }

    @Override
    public ResultSet specificReadQuery(SQLSpecification sqlSpecification) throws SQLException {
        Statement specificReadStatement = NutritionConnection.connection.createStatement();

        return specificReadStatement.executeQuery(sqlSpecification.toSqlClauses());


    }

    @Override
    public int specificUpdateQuery(SQLSpecification sqlSpecification) throws SQLException {
        Statement specificUpdateStatement = NutritionConnection.connection.createStatement();

        int result = specificUpdateStatement.executeUpdate(sqlSpecification.toSqlClauses());

        specificUpdateStatement.close();

        return result;
    }
}
