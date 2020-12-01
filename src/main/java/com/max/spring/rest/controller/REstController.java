package com.max.spring.rest.controller;

import com.max.spring.rest.exeption_handing.NoSuchUserException;
import com.max.spring.rest.models.User;
import com.max.spring.rest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Serov Maxim
 */

@RestController
@RequestMapping("/api")
public class REstController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> showAllUsers() {
       return userService.findAll();
    }

    @GetMapping("/users/{id}")
    public User showAllUser(@PathVariable long id) {
        User user = userService.findById(id);
        if (user == null) {
            throw new NoSuchUserException("There is no user with id = " + id + " in DataBase");
        }
       return userService.findById(id);
    }

    @PostMapping("/users")
    public void showAllUser(@ModelAttribute User user) {
        userService.saveUser(user);
    }


}
