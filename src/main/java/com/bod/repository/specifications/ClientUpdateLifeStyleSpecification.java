package com.bod.repository.specifications;

import com.bod.entity.LifeStyle;
import com.bod.repository.NutritionConnection;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientUpdateLifeStyleSpecification implements SQLSpecification {
    private LifeStyle lifeStyle;
    private int id;

    public ClientUpdateLifeStyleSpecification(LifeStyle lifeStyle, int id) {
        this.lifeStyle = lifeStyle;
        this.id = id;
    }

    @Override
    public PreparedStatement toSqlClauses() throws SQLException {
        PreparedStatement updateStatement = NutritionConnection.getConnection()
                .prepareStatement("UPDATE clients SET lifestyle=? WHERE id=?");

        updateStatement.setString(1, lifeStyle.name());
        updateStatement.setInt(2, id);

        return updateStatement;
    }
}