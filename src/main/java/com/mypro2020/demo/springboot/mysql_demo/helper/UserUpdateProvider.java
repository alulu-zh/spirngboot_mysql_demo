package com.mypro2020.demo.springboot.mysql_demo.helper;

import com.mypro2020.demo.springboot.mysql_demo.entity.User;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.util.StringUtils;

public class UserUpdateProvider {
    private static final String Table_Name = "user";

    public String updateUser(User user) {
        SQL sql = new SQL();
        sql.UPDATE(Table_Name);
        if (!StringUtils.isEmpty(user.getUserName())) {
            sql.SET(String.join(".", Table_Name, "userName = #{userName}"));
        }
        if (!StringUtils.isEmpty(user.getPassWord())) {
            sql.SET(String.join(".", Table_Name, "passWord = #{passWord}"));
        }
        if (!StringUtils.isEmpty(user.getRealName())) {
            sql.SET(String.join(".", Table_Name, "realName = #{realName}"));
        }
        sql.WHERE("id = #{id}");
        return sql.toString();
    }
}
