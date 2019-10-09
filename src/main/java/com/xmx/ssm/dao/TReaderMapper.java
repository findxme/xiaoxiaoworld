package com.xmx.ssm.dao;

import com.xmx.ssm.entity.TReader;
import com.xmx.ssm.entity.TReaderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TReaderMapper {

    TReader findReaderByName(@Param("readerName")String readerName);

    TReader findReaderByNo(@Param("readerNo")String readerNo);

    long countByExample(TReaderExample example);

    int deleteByExample(TReaderExample example);

    int deleteByPrimaryKey(@Param("bReaderId") Integer bReaderId, @Param("bReaderNo") String bReaderNo, @Param("bReaderName") String bReaderName, @Param("bReaderEmail") String bReaderEmail);

    int insert(TReader record);

    int insertSelective(TReader record);

    List<TReader> selectByExample(TReaderExample example);

    TReader selectByPrimaryKey(@Param("bReaderId") Integer bReaderId, @Param("bReaderNo") String bReaderNo, @Param("bReaderName") String bReaderName, @Param("bReaderEmail") String bReaderEmail);

    int updateByExampleSelective(@Param("record") TReader record, @Param("example") TReaderExample example);

    int updateByExample(@Param("record") TReader record, @Param("example") TReaderExample example);

    int updateByPrimaryKeySelective(TReader record);

    int updateByPrimaryKey(TReader record);
}