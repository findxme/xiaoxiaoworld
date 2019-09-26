package com.xmx.ssm.service.impl;

import com.xmx.ssm.dao.UserMapper;
import com.xmx.ssm.entity.User;
import com.xmx.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> findAll(){
        return userMapper.findAll();
    }

    @Override
    public User findUserByName(String username){
        return userMapper.findUserByName(username);
    }

    @Override
    public User findUserById(int id){
        return userMapper.findUserById(id);
    }

    @Override
    public int insertUser(User user){
        return userMapper.insertUser(user);
    }

    @Override
    public int deleteUserByName(String name){
        return userMapper.deleteUserByName(name);
    }

    @Override
    public int updateUser(User user){
        User startUser = findUserById(user.getId());
        if(user.getUserName()==null){
            user.setUserName(startUser.getUserName());
        }
        if(user.getEmail()==null){
            user.setEmail(startUser.getEmail());
        }
        if(user.getPassword()==null){
            user.setPassword(startUser.getPassword());
        }
        if(user.getCity()==null){
            user.setCity(startUser.getCity());
        }
        if(user.getMobile()==null){
            user.setMobile(startUser.getMobile());
        }
        if(user.getAddress()==null){
            user.setAddress(startUser.getAddress());
        }
        if(user.getUserType()==null){
            user.setUserType(startUser.getUserType());
        }
        return userMapper.updateUser(user);
    }
}
