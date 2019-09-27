package com.xmx.ssm.dao;

import com.xmx.ssm.entity.TBookType;
import com.xmx.ssm.entity.TBookTypeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TBookTypeMapper {
    long countByExample(TBookTypeExample example);

    int deleteByExample(TBookTypeExample example);

    int deleteByPrimaryKey(@Param("bBookTypeId") Integer bBookTypeId, @Param("bBookTypeNo") String bBookTypeNo);

    int insert(TBookType record);

    int insertSelective(TBookType record);

    List<TBookType> selectByExample(TBookTypeExample example);

    TBookType selectByPrimaryKey(@Param("bBookTypeId") Integer bBookTypeId, @Param("bBookTypeNo") String bBookTypeNo);

    int updateByExampleSelective(@Param("record") TBookType record, @Param("example") TBookTypeExample example);

    int updateByExample(@Param("record") TBookType record, @Param("example") TBookTypeExample example);

    int updateByPrimaryKeySelective(TBookType record);

    int updateByPrimaryKey(TBookType record);
}