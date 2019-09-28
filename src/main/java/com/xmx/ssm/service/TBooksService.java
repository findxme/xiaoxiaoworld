package com.xmx.ssm.service;


import com.xmx.ssm.entity.TBook;

import java.util.List;

public interface TBooksService {

    /*查找全部*/
    List<TBook> findBooksAll();

    /*删除书本信息*/
    void deleteBooksNo(TBook tBook);

    /*增加书本信息*/
    void insertBook(TBook tBook);

    /*更新书本信息*/
    void  updateBook(TBook tBook);

    /*条件查询*/
    List<TBook> findBooksOne(TBook tBook);

}
