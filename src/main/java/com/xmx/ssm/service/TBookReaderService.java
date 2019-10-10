package com.xmx.ssm.service;

import com.xmx.ssm.entity.TAdmin;
import com.xmx.ssm.entity.TBook;
import com.xmx.ssm.entity.TBookReader;
import com.xmx.ssm.entity.TReader;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TBookReaderService {

    Integer countInfos();

    TBookReader queryInfoByBookReader(String bookNo,String readerNo);

    List<Map<String,Object>> pagingInfo(Integer page,Integer pageSize);

    List<Map<String,Object>> findAll();

    int borrowBook(TBook tBook, TReader tReader);

    int returnBook(TBook tBook,TReader tReader);


    List<TBookReader> findBookByReader(TReader tReader);

    int deleteInfoByNo(TBookReader tBookReader);

    int renewBook(TBook tBook, TReader tReader, String borrowDate);

    /*查询多少书借出去了*/
    long findReadersBorrowingQuantity();
}
