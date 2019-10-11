package com.xmx.test;

import com.xmx.ssm.dao.TAdminMapper;
import com.xmx.ssm.dao.TBookMapper;
import com.xmx.ssm.dao.TBookReaderMapper;
import com.xmx.ssm.dao.TBookTypeMapper;
import com.xmx.ssm.entity.*;
import com.xmx.ssm.service.TAdminService;
import com.xmx.ssm.service.TBookReaderService;
import com.xmx.ssm.service.TBooksService;
import com.xmx.ssm.service.TReadersService;
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
//    @Resource
//    private TAdminService tAdminService;
    @Resource
    private  TBooksService tBooksService;
    @Resource
    private TBookTypeMapper tBookTypeMapper;

//    @Autowired
//    private  TBookMapper tBookMapper;


    @Test
    public void test()throws Exception{
//        TAdmin tAdmin = new TAdmin();
//        tAdmin.setbAdminCreateDate(new Date());
//        tAdmin.setbAdminEmail("1");
//        tAdmin.setbAdminName("1");
//        tAdmin.setbAdminPassword("1");
//        tAdmin.setbAdminStopDate(new Date());
//        tAdmin.setbAdminType("1");
//        tAdmin.setbAdminNo("1222");
////        tAdminService.queryTAdmin();
//        int flag = tAdminService.insert(tAdmin);
//        System.out.println(tAdminService.findAdminByName("admin"));
        TBookExample example;
        System.out.println(123);
//        tBookMapper.findBooksAll();
//     TBook tbook  =tBookMapper.selectByPrimaryKey(1,"1");
//        List<Map<String,Object>> a =tBooksService.findBooksAll();

//       TBook a= tBooksService.selectByPrimaryKey("2");
        TBook tBook =new TBook();
//        tBook.setbBookNo("123");
//        tBook.setbBookName("熊熊二号");
//        tBook.setbBookAuthor("小熊熊2");
//        tBook.setbBookNumber(2);
//        tBook.setbBookType("动物类7");
      // tBook.setbBookCreatedate(new Date());

//        List<Map<String ,Object>> a=  tBooksService.findBooksOne(tBook);
//tBook.setbBookNo("123");
//tBooksService.deleteBooksNo(tBook);

//        System.out.println(123+a.toString());
//        System.out.println("+123"+a);
//        TBookType tBookType =new TBookType();
//        tBookType.setbBookTypeNo("type6");
//        tBookType.setbBookType("熊熊");
////        tBookType.setbBookTypeNo("type1");
//////       List<Map<String,Object>>  a=tBookTypeMapper.selectBooksTypeOne(tBookType);
//        tBookTypeMapper.insertTBookType(tBookType);
//        System.out.println();

        List<Map<String,Object>> list =tBooksService.countBooksTypeQuantity();
        System.out.println(list);
        System.out.println(list.get(1).get("quantity"));

    }
    @Resource
    private TReadersService tReadersService;

    @Resource
    private TAdminService tAdminService;
    @Resource
    private TAdminMapper tAdminMapper;


    @Resource
    private TBookReaderMapper tBookReaderMapper;

    @Test
    public void test2(){
//        TReader tReader = tReadersService.findReaderByNo("reader");
//        System.out.println(tReader);


    }


    @Resource
    private TBookReaderService tBookReaderService;

    @Test
    public void test3(){
        TBook tBook = tBooksService.selectByPrimaryKey("1");
        TReader tReader = tReadersService.findReaderByNo("reader");
        TAdmin tAdmin = tAdminService.findAdminByNo("admin3");
        System.out.println(tBookReaderService.renewBook(tBook,tReader));
    }


}
