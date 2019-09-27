package com.xmx.test;

import com.xmx.ssm.dao.TAdminMapper;
import com.xmx.ssm.entity.TAdmin;
import com.xmx.ssm.entity.TAdminExample;
import com.xmx.ssm.service.TAdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith( SpringJUnit4ClassRunner.class )
@ContextConfiguration(locations = {"classpath*:spring-mybatis.xml"})
public class MyTest {
    @Resource
    private TAdminMapper tAdminService;

    @Test
    public void test()throws Exception{
        TAdmin tAdmin = new TAdmin();
        tAdmin.setbAdminCreateDate(new Date());
        tAdmin.setbAdminEmail("1");
        tAdmin.setbAdminName("1");
        tAdmin.setbAdminPassword("1");
        tAdmin.setbAdminStopDate(new Date());
        tAdmin.setbAdminType("1");
        tAdmin.setbAdminNo("122");
////        tAdminService.queryTAdmin();
        int flag = tAdminService.insert(tAdmin);
        System.out.println(flag);

    }
}
