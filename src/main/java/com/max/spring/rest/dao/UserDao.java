package com.max.spring.rest.dao;

import com.max.spring.rest.models.User;

import java.util.List;

public interface UserDao {
    void saveUser(User user);

    User findById(long id);

    void updateUser(User updateUser);

    void deleteUser(long id);

    List<User> findAll();

}
