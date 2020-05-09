package com.mypro2020.demo.springboot.mysql_demo.controller;

import com.mypro2020.demo.springboot.mysql_demo.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping(value = "hello/{name}")
    public String getHello(@PathVariable String name) {
        return String.format("hello world: %s\n", name);
    }
}
