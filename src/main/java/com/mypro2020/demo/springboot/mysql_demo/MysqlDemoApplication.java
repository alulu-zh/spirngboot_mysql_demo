package com.mypro2020.demo.springboot.mysql_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(value = {"com.mypro2020.demo.springboot.mysql_demo.mapper"})
@EnableTransactionManagement
public class MysqlDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MysqlDemoApplication.class, args);
    }
}
