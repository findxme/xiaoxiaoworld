package com.xmx.test;

import com.xmx.ssm.dao.TAdminMapper;
import com.xmx.ssm.dao.TBookMapper;
import com.xmx.ssm.entity.TAdmin;
import com.xmx.ssm.entity.TAdminExample;
import com.xmx.ssm.entity.TBook;
import com.xmx.ssm.entity.TBookExample;
import com.xmx.ssm.service.TAdminService;
import com.xmx.ssm.service.TBooksService;
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
tBook.setbBookNo("123");
tBooksService.deleteBooksNo(tBook);

//        System.out.println(123+a.toString());
//        System.out.println("+123"+a);

    }
}
