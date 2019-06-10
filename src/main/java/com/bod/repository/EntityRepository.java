package com.bod.repository;


import java.sql.ResultSet;
import java.sql.SQLException;

public interface EntityRepository {
    void createEntity(Object... nums) throws SQLException;

    ResultSet readEntity(int id) throws SQLException;

    void deleteEntity(int id) throws SQLException;

    int updateEntity(Object... nums) throws SQLException;
}
