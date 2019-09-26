package com.xmx.ssm.service;

import com.xmx.ssm.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findUserByName(String name);

    User findUserById(int id);

    int insertUser(User user);

    int deleteUserByName(String name);

    int updateUser(User user);
}
