package com.bod.repository;

import com.bod.repository.specifications.SQLSpecification;

import java.sql.SQLException;

public interface  UpdateQuery {
    int specificUpdateQuery(SQLSpecification sqlSpecification) throws SQLException;
}