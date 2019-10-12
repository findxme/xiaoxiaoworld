package com.xmx.ssm.service;


import com.xmx.ssm.entity.TBookType;

import java.util.List;
import java.util.Map;

public interface TBooksTypeService {


    /*OK*/
    /*查出有多少条记录ok*/
    long countByExample();

    List<Map<String ,Object>> findBooksTypeLimit(int currIndex,int pageSize);

    /*ok*/
    /*根据查找书本类型*/
    List<Map<String ,Object>> selectBooksTypeOne(TBookType tBookType);

    /*ok*/
    /*增加书籍信息 需要传入no和type*/
    int insertTBookType(TBookType record);


    /*ok*/
    /*查询全部*/
    List<Map<String ,Object>>   selectBooksType();

    int updateBookType(TBookType tBookType);

    /*ok*/
    /*删除书本类型*/
   void deleteBooksType(TBookType tBookType);




}
