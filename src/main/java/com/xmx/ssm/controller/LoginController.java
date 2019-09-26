package com.xmx.ssm.controller;

import com.xmx.ssm.entity.StatusInfo;
import com.xmx.ssm.entity.User;
import com.xmx.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/toRegister")
    public String toRegister(){
        return "register";
    }

    @RequestMapping(value = "/register",method = RequestMethod.POST)
    @ResponseBody
    public StatusInfo register(@RequestParam("userType")String userType,
                           @RequestParam("username")String username,
                           @RequestParam("password")String password,
                           @RequestParam("email")String email,
                           @RequestParam("mobile")String mobile,
                           @RequestParam("address")String address,
                           @RequestParam("city")String city){
        User user = new User();
        user.setUserType(userType);
        user.setUserName(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setMobile(mobile);
        user.setAddress(address);
        user.setCity(city);
        int result = userService.insertUser(user);
        StatusInfo info = new StatusInfo();
        if(result==1){
            info.setMessage("注册成功");
        }else{
            info.setStatus(500);
            info.setMessage("注册失败");
        }
        return info;
    }
}
