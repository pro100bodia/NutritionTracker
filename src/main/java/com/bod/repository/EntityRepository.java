package com.bod.repository;


import java.sql.ResultSet;
import java.sql.SQLException;

//todo add connection pool
//todo add isolated transactions
public interface EntityRepository {
    void createEntity() throws SQLException;

    ResultSet readEntity() throws SQLException;

    void deleteEntity() throws SQLException;
}
