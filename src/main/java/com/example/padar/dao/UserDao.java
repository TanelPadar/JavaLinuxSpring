package com.example.padar.dao;

import com.example.padar.mapper.UserMapper;
import com.example.padar.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_ALL_USERS = "SELECT * FROM user";

    private static final String SQL_GET_USER_BY_ID = "SELECT id,name,username,email FROM user where id = ?";

    private static final String SQL_GET_POSTED_USER = "SELECT id,username,email FROM user ORDER BY id DESC LIMIT 1 ";

    private static final String SQL_DELETE_USER_BY_ID = "DELETE FROM user WHERE id=? and ownedby=?";

    private static final String SQL_MAKE_NEW_USER = "INSERT INTO user(name,username,email,ownedby) VALUES(?,?,?,?)";

    private static final String SQL_UPDATE_USER = "UPDATE user SET name = ?, username = ?, email = ? WHERE id=? and ownedby=?";
    public List<User> getAllUsers() {
        return jdbcTemplate.query(SQL_GET_ALL_USERS, new UserMapper());
    }

    public int deleteUserById(int id, String auth) {
        return jdbcTemplate.update(SQL_DELETE_USER_BY_ID, id,auth);
    }

    public List<User> getUserById(int id) {return jdbcTemplate.query(SQL_GET_USER_BY_ID,new UserMapper(),id); }
    public List<User> showPostedUser() {return jdbcTemplate.query(SQL_GET_POSTED_USER,new UserMapper()); }

    public void addUser(User user, String auth) {
        jdbcTemplate.update(SQL_MAKE_NEW_USER,
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                auth);
    }


    public int updateUser(User user, int id, String auth) {
        return jdbcTemplate.update(SQL_UPDATE_USER,
                user.getName(),
                user.getUsername(),
                user.getEmail(),
                id,
                auth);
    }
}
