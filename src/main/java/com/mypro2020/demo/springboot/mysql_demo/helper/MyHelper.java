package com.mypro2020.demo.springboot.mysql_demo.helper;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class MyHelper {
    private String name;

    public MyHelper() {
        this.name = "zhouhu123";
    }
}
