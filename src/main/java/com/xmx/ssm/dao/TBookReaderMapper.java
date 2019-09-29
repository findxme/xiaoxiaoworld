package com.xmx.ssm.dao;

import com.xmx.ssm.entity.TBookReader;
import com.xmx.ssm.entity.TBookReaderExample;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TBookReaderMapper {


//    @Select("select * from t_book_reader limit #{currentIndex},#{pageSize}")
    List<Map<String,Object>> pagingInfo(@Param("currentIndex")Integer currentIndex,@Param("pageSize")Integer pageSize);

    TBookReader queryInfoByBookReaderDate(@Param("bookNo")String bookNo,@Param("readerNo")String readerNo,@Param("borrowDate") String borrowDate);

    List<Map<String,Object>> findAll();

    long countByExample(TBookReaderExample example);

    int deleteByExample(TBookReaderExample example);

    int deleteByPrimaryKey(@Param("bBookReaderId") Integer bBookReaderId, @Param("bBookNo") String bBookNo, @Param("bReaderNo") String bReaderNo, @Param("bUserNo") String bUserNo);

    int insert(TBookReader record);

    int insertSelective(TBookReader record);

    List<TBookReader> selectByExample(TBookReaderExample example);

    TBookReader selectByPrimaryKey(@Param("bBookReaderId") Integer bBookReaderId, @Param("bBookNo") String bBookNo, @Param("bReaderNo") String bReaderNo, @Param("bUserNo") String bUserNo);

    int updateByExampleSelective(@Param("record") TBookReader record, @Param("example") TBookReaderExample example);

    int updateByExample(@Param("record") TBookReader record, @Param("example") TBookReaderExample example);

    int updateByPrimaryKeySelective(TBookReader record);

    int updateByPrimaryKey(TBookReader record);
}