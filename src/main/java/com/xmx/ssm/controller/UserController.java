package com.xmx.ssm.controller;

import com.xmx.ssm.entity.User;
import com.xmx.ssm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService studentService;

    @RequestMapping("/studentList")
    public String findAll(Model model){
        List<User> students = studentService.findAll();
        model.addAttribute("students",students);
        return "student/studentList";
    }
}
