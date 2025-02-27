package com.Akash.BookManagementSystem.Repository;


import com.Akash.BookManagementSystem.Model.UserDataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.logging.Logger;

@Repository
public class UserDataRepository
{
    @Autowired
    private JdbcTemplate jdbcTemplate;


    Logger logger = Logger.getLogger(BookCartServiceRepository.class.getName());

    private String INSERT_USER = "INSERT INTO book_users (first_name, last_name, phone_no , email_id, password) VALUES (?,?,?,?,?)";

    private String GET_USER = "SELECT * FROM book_users WHERE user_id = ?";

    public void addUser(UserDataModel user) {
        logger.info("Adding user");
        this.jdbcTemplate.update(INSERT_USER, user.getFirstName(), user.getLastName(), user.getPhoneNo(), user.getEmail(), user.getPassword());
    }

    public UserDataModel getUser(int bookId) {
        logger.info("Fetching book with id");
        return this.jdbcTemplate.queryForObject(GET_USER, new Object[]{bookId}, new BeanPropertyRowMapper<>(UserDataModel.class));
    }
}
