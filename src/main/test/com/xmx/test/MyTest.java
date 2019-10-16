package com.xmx.test;

import com.xmx.ssm.dao.TAdminMapper;
import com.xmx.ssm.dao.TBookMapper;
import com.xmx.ssm.dao.TBookTypeMapper;
import com.xmx.ssm.entity.*;
import com.xmx.ssm.service.TAdminService;
import com.xmx.ssm.service.TBookReaderService;
import com.xmx.ssm.service.TBooksService;
import com.xmx.ssm.service.TReadersService;
import com.xmx.ssm.util.AES;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(locations = {"classpath*:spring-mybatis.xml"})
public class MyTest {

    @Resource
    private TBookReaderService tBookReaderService;

    @Resource
    private TAdminService tAdminService;

    @Resource
    private TBooksService tBooksService;

    @Resource
    private TReadersService tReadersService;

    @Resource
    private AES aes;



    @Test
    public void test(){

        TAdmin tAdmin = tAdminService.findAdminByNo("admin1");

        TBook tBook = tBooksService.selectByPrimaryKey("1");

        TReader tReader = tReadersService.findReaderByNo("ads");

//        System.out.println(tReader);

        System.out.println(tBookReaderService.borrowBook(tBook,tReader,tAdmin));

//        System.out.println(tBooksService.findBooksLimit("type6",1,20));
    }

    @Test
    public void test4(){
 /*       String a = "abc";
        String b = new String("abc");
        String c = "a"+"b"+"c";
        System.out.println(a==b);//false
        System.out.println(a==c);//true
        System.out.println(a.equals(b));//true
        System.out.println(a.equals(c));//true
        System.out.println(a.intern()==b.intern());//true*/
//        AES aes= new AES();
         String a=aes.aesEncrypt("pjhbkznjxidweaia");
        String decrypt =aes.aesDecrypt(a);
        System.out.println("解密后：" + decrypt);
        System.err.println(a);
    }
}
