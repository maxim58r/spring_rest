package com.max.spring.rest.service;

import com.max.spring.rest.models.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);

    User findById(long id);

    void deleteUser(long id);

    List<User> findAll();

}

