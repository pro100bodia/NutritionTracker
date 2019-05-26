package com.bod.repository.specifications;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface SQLSpecification {
    PreparedStatement toSqlClauses() throws SQLException;
}