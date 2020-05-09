package com.mypro2020.demo.springboot.mysql_demo.controller;

import com.mypro2020.demo.springboot.mysql_demo.entity.User;
import com.mypro2020.demo.springboot.mysql_demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "user/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        User u = userService.getUserById(id);
        return u;
    }
    @PostMapping(path = "user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User addUser(@RequestBody User user) {
        User u = new User();
        u.setUserName(user.getUserName());
        u.setPassWord(user.getPassWord());
        u.setRealName(user.getRealName());
        userService.addUser(u);
        return u;
    }

    @PutMapping(path = "user", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public User updateUser(@RequestBody User user) {
        User u = userService.updateUser(user);
        return u;
    }
    @DeleteMapping(path = "user/{id}")
    public Integer deleteUserById(@PathVariable("id") Integer id) {
        return userService.deleteUserById(id);
    }
}
