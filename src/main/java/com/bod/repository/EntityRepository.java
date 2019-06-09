package com.bod.repository;


import com.bod.entity.Databaseable;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EntityRepository {
    void createEntity(Object... nums) throws SQLException;

    ResultSet readEntity(int id) throws SQLException;

    void deleteEntity(int id) throws SQLException;

    int updateEntity(Databaseable entity) throws SQLException;
}
