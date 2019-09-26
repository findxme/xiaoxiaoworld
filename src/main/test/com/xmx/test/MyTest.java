package com.xmx.test;

import com.xmx.ssm.entity.User;
import com.xmx.ssm.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.Iterator;
import java.util.List;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(locations = {"classpath*:spring-mybatis.xml"})
public class MyTest {
    @Resource
    private UserService userService;

    @Test
    public void test(){
        User user = new User();
        user.setAddress("1");
        user.setCity("1");
        user.setEmail("1");
        user.setMobile("1");
        user.setPassword("1");
        user.setUserName("1");
        user.setUserType("1");
        userService.insertUser(user);
//        List<User> users = userService.findAll();
//        for(int j=0;j<users.size();j++){
//            System.out.println(users.get(j));
//        }
//        System.out.println(userService.deleteUserByName("1"));
}
}
