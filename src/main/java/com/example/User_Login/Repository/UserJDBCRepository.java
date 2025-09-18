package com.example.User_Login.Repository;

import com.example.User_Login.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserJDBCRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> getJdbcUserList(String userName) {
        String sql = "select * from app_user where first_name like '%" + userName + "%'";
        return jdbcTemplate.query(sql, (rs, rowNo) -> new User(
                rs.getInt("id"),
                rs.getString("first_name"),
                rs.getString("last_name"),
                rs.getString("email"),
                null,
                rs.getString("mobile_no"),
                rs.getBoolean("status")));
    }
}
