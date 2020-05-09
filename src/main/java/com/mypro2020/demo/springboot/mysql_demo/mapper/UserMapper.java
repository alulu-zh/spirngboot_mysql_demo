package com.mypro2020.demo.springboot.mysql_demo.mapper;

import com.mypro2020.demo.springboot.mysql_demo.entity.User;
import com.mypro2020.demo.springboot.mysql_demo.helper.UserUpdateProvider;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

//@Repository
public interface UserMapper {
    @Select("select * from user where id=#{id}")
    User getUserById(Integer id);

    @Insert({"insert into user(userName,passWord,realName) values(#{userName},#{passWord},#{realName})"})
    @SelectKey(statement = "select last_insert_id()", keyProperty = "id", before = false, resultType = Integer.class)
    Integer addUser(User user);

//    @Update("update user set userName=#{userName},passWord=#{passWord},realName=#{realName} where id=#{id}")
//    Integer updateUser(User user);
    @UpdateProvider(type = UserUpdateProvider.class, method = "updateUser")
    Integer updateUser(User user);

    @Delete("delete from user where id = #{id}")
    Integer deleteUserById(Integer id);
}
