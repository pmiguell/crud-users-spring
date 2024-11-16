package com.pmiguell.usercrud.user_management.controller;

import com.pmiguell.usercrud.user_management.model.User;
import com.pmiguell.usercrud.user_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/id/{id}")
    public Optional<User> getById(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    @GetMapping("/username/{username}")
    public Optional<User> getByUsername(@PathVariable("username") String username) {
        return userService.findByUsername(username);
    }

    @PostMapping
    public void postUser(@RequestBody User user) {
        userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        userService.deleteById(id);
    }

    @PutMapping
    public void putUser(@RequestBody User user) {
         userService.save(user);
    }
}
