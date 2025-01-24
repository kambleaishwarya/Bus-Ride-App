package com.pinnacle.bus.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.pinnacle.bus.model.User;

@Repository
public class PostgreSQLRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static class UserRowMapper implements RowMapper<User> {

        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId((rs.getString("id")));  
            user.setName(rs.getString("username")); 
            user.setEmail(rs.getString("email"));
            user.setEmailVerified(rs.getTimestamp("email_verified") != null ? 
                rs.getTimestamp("email_verified").toLocalDateTime() : null);
            user.setImage(rs.getString("image"));
            user.setCreatedAt(rs.getTimestamp("created_at") != null ? 
                rs.getTimestamp("created_at").toLocalDateTime() : null);
            user.setUpdatedAt(rs.getTimestamp("updated_at") != null ? 
                rs.getTimestamp("updated_at").toLocalDateTime() : null);
            user.setRole(rs.getString("role"));
        
            return user;
        }
    }

    public int save(User user) {
        String sql = "INSERT INTO users (username, email, role, created_at, updated_at) VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getRole(), 
                                   user.getCreatedAt(), user.getUpdatedAt());
    }

    public User findById(String id) {  
        String sql = "SELECT * FROM users WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new UserRowMapper());
    }

    public List<User> findAll() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, new UserRowMapper());
    }

    public int update(User user) {
        String sql = "UPDATE users SET username = ?, email = ?, role = ?, updated_at = ? WHERE id = ?";
        return jdbcTemplate.update(sql, user.getName(), user.getEmail(), user.getRole(), 
                                   user.getUpdatedAt(), user.getId());
    }

    public int delete(String id) {  
        String sql = "DELETE FROM users WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}