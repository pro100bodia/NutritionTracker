package com.bod.repository;

import com.bod.repository.specifications.SQLSpecification;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CoefsRepository implements EntityRepository, UpdateQuery {
    private int id;
    private double forMen, forWomen;

    public CoefsRepository(int id, double forMen, double forWomen) {
        this.id = id;
        this.forMen = forMen;
        this.forWomen = forWomen;
    }

    @Override
    public void createEntity() throws SQLException {
        Statement createStatement = NutritionConnection.connection.createStatement();

        createStatement.execute(String.format("INSERT INTO coefs VALUES(%d, %f, %f)",
                id, forMen, forWomen));

        createStatement.close();
    }

    @Override
    public ResultSet readEntity() throws SQLException {
        Statement readStatement = NutritionConnection.connection.createStatement();
        return readStatement.executeQuery("SELECT * FROM coefs");
    }

    @Override
    public void deleteEntity() throws SQLException {
        Statement deleteStatement = NutritionConnection.connection.createStatement();
        deleteStatement.execute("DELETE FROM coefs WHERE id=%d", id);
        deleteStatement.close();
    }

    @Override
    public int specificUpdateQuery(SQLSpecification sqlSpecification) throws SQLException {
        Statement specificUpdateStatement = NutritionConnection.connection.createStatement();

        return specificUpdateStatement.executeUpdate(sqlSpecification.toSqlClauses());
    }
}
