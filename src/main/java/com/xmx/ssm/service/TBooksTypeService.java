package com.xmx.ssm.service;


import com.xmx.ssm.entity.TBookType;

import java.util.List;
import java.util.Map;

public interface TBooksTypeService {
    /*增加书本类型*/
    void insterBooksType(TBookType tbooksType);

    /*查找书本类型*/
    List<Map<String ,Object>> selectBooksType(TBookType tBookType);

    /*删除书本类型*/
   void deleteBooksType(TBookType tBookType);

    /*更新书本信息*/
    void  updateBookType(TBookType tBookType);



}
