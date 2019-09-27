package com.xmx.ssm.dao;

import com.xmx.ssm.entity.TBookReader;
import com.xmx.ssm.entity.TBookReaderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBookReaderMapper {
    long countByExample(TBookReaderExample example);

    int deleteByExample(TBookReaderExample example);

    int deleteByPrimaryKey(@Param("bBookReaderId") Integer bBookReaderId, @Param("bBookNo") String bBookNo, @Param("bReaderNo") String bReaderNo);

    int insert(TBookReader record);

    int insertSelective(TBookReader record);

    List<TBookReader> selectByExample(TBookReaderExample example);

    TBookReader selectByPrimaryKey(@Param("bBookReaderId") Integer bBookReaderId, @Param("bBookNo") String bBookNo, @Param("bReaderNo") String bReaderNo);

    int updateByExampleSelective(@Param("record") TBookReader record, @Param("example") TBookReaderExample example);

    int updateByExample(@Param("record") TBookReader record, @Param("example") TBookReaderExample example);

    int updateByPrimaryKeySelective(TBookReader record);

    int updateByPrimaryKey(TBookReader record);
}