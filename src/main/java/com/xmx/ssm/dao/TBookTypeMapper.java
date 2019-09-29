package com.xmx.ssm.dao;

import com.xmx.ssm.entity.TBookType;
import com.xmx.ssm.entity.TBookTypeExample;
import java.util.List;
import java.util.Map;

import com.xmx.ssm.service.TBooksTypeService;
import org.apache.ibatis.annotations.Param;

public interface TBookTypeMapper {

    /*ok*/
    /*查找有多少条数据*/
    long countByExample();

    /*ok*/
    /*根据查找书本类型*/
    List<Map<String ,Object>> selectBooksTypeOne(TBookType tBookType);

     /*ok*/
    /*查询全部*/
    List<Map<String ,Object>> selectBooksType();

    /*增加书本类型*/
    int insertTBookType(TBookType record);

    /*删除书本类型*/
    void deleteBooksType(TBookType tBookType);

}