package com.daily.expense.controller;

import com.daily.expense.model.User;
import com.daily.expense.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/signup")
    public User createUser(@RequestBody User user) {
        user.setCreatedDate(new Date());
        return userRepository.save(user);
    }

    @PostMapping("/login")
    public boolean login(@RequestParam String name, @RequestParam String password) {
        User user = userRepository.findByName(name);
        if (user != null && user.getPassword().equals(password)) {
            return true; // Login successful
        }
        return false; // Login failed
    }
}
