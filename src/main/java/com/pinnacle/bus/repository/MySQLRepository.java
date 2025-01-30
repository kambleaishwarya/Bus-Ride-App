package com.pinnacle.bus.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pinnacle.bus.model.Fare;

@Repository
public class MySQLRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MySQLRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertFare(Fare fare) {
        String sql = "INSERT INTO fare (id, route_id, from_location_id, to_location_id, price, created_by_user_id) " +
                "VALUES (?, ?, ?, ?, ?, ?)";

        String generatedId = UUID.randomUUID().toString();

        return jdbcTemplate.update(sql, generatedId, fare.getRouteId(), fare.getFromLocationId(),
                fare.getToLocationId(), fare.getPrice(), fare.getCreatedByUserId());
    }

    public Fare getFareById(String id) {
        String sql = "SELECT * FROM fare WHERE id = ?";

        return jdbcTemplate.queryForObject(sql, new Object[] { id }, new FareRowMapper());
    }

    // List all fares
    public List<Fare> getAllFares() {
        String sql = "SELECT * FROM fare";

        return jdbcTemplate.query(sql, new FareRowMapper());
    }

    private static class FareRowMapper implements RowMapper<Fare> {
        @Override
        public Fare mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new Fare(
                    rs.getString("id"),
                    rs.getString("route_id"),
                    rs.getString("from_location_id"),
                    rs.getString("to_location_id"),
                    rs.getFloat("price"),
                    rs.getString("created_by_user_id"));
        }
    }
}