package com.max.spring.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.max.spring.rest.dao.UserDao;
import com.max.spring.rest.models.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

    @Autowired
    private UserDao userDao;

    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(long id) {
        return userDao.findById(id);
    }

    @Transactional
    @Override
    public void deleteUser(long id) {
        userDao.deleteUser(id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
