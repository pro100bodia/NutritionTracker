package com.bod.repository;

import java.sql.SQLException;

public interface UpdateQuery {
    int specificUpdateQuery(SQLSpecification sqlSpecification) throws SQLException;
}
