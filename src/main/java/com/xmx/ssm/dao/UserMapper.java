package com.xmx.ssm.dao;

import com.xmx.ssm.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    List<User> findAll();

    User findUserById(@Param("id")int id);

    User findUserByName(@Param("username")String username);

    int insertUser(@Param("user") User user);

    int deleteUserByName(@Param("name")String name);

    int updateUser(@Param("user")User user);
}
