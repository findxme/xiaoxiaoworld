package com.xmx.ssm.service;


import com.xmx.ssm.entity.TReader;

import java.util.List;
import java.util.Map;

public interface TReadersService {


    long countByExample();

    List<Map<String, Object>> findReaderLimit(int currIndex, int pageSize);

    List<Map<String ,Object>> findReaderOne(String no);

    List<Map<String ,Object>> findReaderNameOne(String name);
    /*查找全部*/
    List<Map<String, Object>> findReadersAll();

    /*删除读者信息*/
    int deleteReadersNo(TReader tReader);

    /*增加读者信息*/
    int insertReader(TReader tReader);

    /*更新读者信息*/
    int updateReader(TReader tReader);

    int updateByName(TReader tReader);
    /*条件查询*/
    List<TReader> findReadersOne(TReader tReader);



    TReader findReaderByNo(String readerNo);

    TReader findReaderByName(String readerName);

    int insertReaderSelective(TReader tReader);
}
