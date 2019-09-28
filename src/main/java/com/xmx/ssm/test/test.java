package com.xmx.ssm.test;

import com.xmx.ssm.dao.TBookMapper;
import com.xmx.ssm.entity.TBookExample;
import com.xmx.ssm.service.TBooksService;
import com.xmx.ssm.service.impl.TBooksServiceImpl;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)	// 不能是PowerMock等别的class，否则无法识别spring的配置文件
@ContextConfiguration({"classpath:spring-mvc.xml","classpath:spring-mybatis.xml"})	// 读取spring配置文件
public class test {
    public static void main(String[] args) {
        TBooksServiceImpl tBooksService=new TBooksServiceImpl();
        System.out.println(tBooksService.countByExample( new TBookExample()));



    }
}
