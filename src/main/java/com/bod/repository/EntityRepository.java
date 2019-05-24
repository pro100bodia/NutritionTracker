package com.bod.repository;


import java.sql.ResultSet;
import java.sql.SQLException;

public interface EntityRepository {
    void createEntity() throws SQLException;

    ResultSet readEntity() throws SQLException;

    void deleteEntity() throws SQLException;
}
