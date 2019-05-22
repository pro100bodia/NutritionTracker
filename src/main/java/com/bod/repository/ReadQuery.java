package com.bod.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface ReadQuery {
    ResultSet specificReadQuery(SQLSpecification sqlSpecification) throws SQLException;
}
