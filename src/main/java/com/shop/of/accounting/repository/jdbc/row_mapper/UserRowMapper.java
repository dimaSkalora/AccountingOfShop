package com.shop.of.accounting.repository.jdbc.row_mapper;

import com.shop.of.accounting.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserRowMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet resultSet, int i) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setName(resultSet.getString("name"));
        user.setEmail(resultSet.getString("email"));
        user.setPassword(resultSet.getString("password"));
        user.setRegistered(resultSet.getDate("registered"));
        //user.setRoles(resultSet.getArray("roles"));
        user.setEnabled(resultSet.getBoolean("enabled"));

        return user;
    }
}
