package com.xmx.ssm.service;

import com.xmx.ssm.entity.TAdmin;
import com.xmx.ssm.entity.TBook;
import com.xmx.ssm.entity.TBookReader;
import com.xmx.ssm.entity.TReader;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TBookReaderService {


    Integer countInfos();

    TBookReader queryInfoByBookReader(String bookNo,String readerNo);

    List<Map<String,Object>> pagingInfo(String keyWord,String startDate,String endDate,Integer page,Integer pageSize);

    List<Map<String,Object>> queryNotReturnInfo(String startDate,String endDate,String keyWord,Integer page,Integer pageSize);

    List<Map<String,Object>> findAll();

    List<Map<String,Object>> findInfoByBook(String bookNo,Integer page,Integer pageSize);

    int borrowBook(TBook tBook, TReader tReader,TAdmin tAdmin);

    int returnBook(TBook tBook,TReader tReader,TAdmin tAdmin);




    List<TBookReader> findBookByReader(TReader tReader);

    int deleteInfoByNo(TBookReader tBookReader);

    int renewBook(TBook tBook, TReader tReader);

    /*查询多少书借出去了*/
    long findReadersBorrowingQuantity();

    /*查询当天借阅记录*/
    List<Map<String,Object>> selectDay(@Param("currIndex") int currIndex, @Param("pageSize") int pageSize);

    List<Map<String,Object>> findOneReaderByBook(@Param("name")String name,@Param("currIndex") int currIndex, @Param("pageSize") int pageSize);

    long findOneReaderByBookQuantity(@Param("name")String name);

    long countBydayQuantity();
}
