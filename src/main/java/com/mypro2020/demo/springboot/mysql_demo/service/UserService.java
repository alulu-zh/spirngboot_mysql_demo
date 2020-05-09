package com.mypro2020.demo.springboot.mysql_demo.service;

import com.mypro2020.demo.springboot.mysql_demo.entity.User;
import com.mypro2020.demo.springboot.mysql_demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    private final UserMapper userMapper;
    @Autowired
    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    public Integer addUser(User user) {
        return userMapper.addUser(user);
    }

    @Transactional
    public User updateUser(User user) {
        userMapper.updateUser(user);
        return userMapper.getUserById(user.getId());
    }

    public Integer deleteUserById(Integer id) {
        return userMapper.deleteUserById(id);
    }
}
