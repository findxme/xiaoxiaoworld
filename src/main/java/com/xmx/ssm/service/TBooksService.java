package com.xmx.ssm.service;


import com.xmx.ssm.entity.TBook;
import com.xmx.ssm.entity.TBookExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TBooksService {

    /*OK*/
    /*查出有多少条记录ok*/
    long countByExample();

    /*ok*/
    /*查找全部*/
    List<Map<String ,Object>> findBooksAll();

    /*OK*/
    /*条件查询 ok*/
    List<Map<String ,Object>> findBooksOne(TBook tBook);


    /*OK*/
    /*根据主键查找数据 nook*/
    TBook selectByPrimaryKey(@Param("bBookNo") String bBookNo);


    /*OK*/
    /*增加啊书本信息 图书编号，图书书名，作者，书店类型，书的入库时间，必填ok*/
    int insertBooks(TBook record);

    /*OK*/
    /*根据no建插入信息，作者，书店类型，书的入库时间，必填ok*/
    int insertSelective(TBook record);

    /*OK*/
    /* 根据no字段更新数据ok*/
    int updateByExample(TBook record);

    /*删除书本信息*/
    void deleteBooksNo(TBook tBook);

    /**
     * 分页查询
     * @param currIndex
     * @param pageSize
     * @return
     */
    List<Map<String ,Object>> findBooksLimit(@Param("currIndex") int currIndex,@Param("pageSize") int pageSize);


    /*查出每种数的类型有多少本 数量字段名quantity*/
    List<Map<String,Object>> countBooksTypeQuantity();

}
