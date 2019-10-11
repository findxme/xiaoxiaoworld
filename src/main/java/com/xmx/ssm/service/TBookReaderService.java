package com.xmx.ssm.service;

import com.xmx.ssm.entity.TAdmin;
import com.xmx.ssm.entity.TBook;
import com.xmx.ssm.entity.TBookReader;
import com.xmx.ssm.entity.TReader;

import java.util.List;
import java.util.Map;

public interface TBookReaderService {


    Integer countInfos();

    TBookReader queryInfoByBookReader(String bookNo,String readerNo);

    List<Map<String,Object>> pagingInfo(Integer page,Integer pageSize);

    List<Map<String,Object>> queryNotReturnInfo(Integer page,Integer pageSize);

    List<Map<String,Object>> findAll();

    List<Map<String,Object>> findInfoByBook(String bookNo,Integer page,Integer pageSize);

    int borrowBook(TBook tBook, TReader tReader,TAdmin tAdmin);

    int returnBook(TBook tBook,TReader tReader,TAdmin tAdmin);




    List<TBookReader> findBookByReader(TReader tReader);

    int deleteInfoByNo(TBookReader tBookReader);

    int renewBook(TBook tBook, TReader tReader);
}
