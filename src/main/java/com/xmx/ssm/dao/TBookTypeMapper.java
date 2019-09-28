package com.xmx.ssm.dao;

import com.xmx.ssm.entity.TBookType;
import com.xmx.ssm.entity.TBookTypeExample;
import java.util.List;
import java.util.Map;

import com.xmx.ssm.service.TBooksTypeService;
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


    /*增加书本类型*/
    void insterBooksType(TBookType tbooksType);

    /*查找书本类型*/
    List<Map<String ,Object>> selectBooksType(TBookType tBookType);

    /*删除书本类型*/
    void deleteBooksType(TBookType tBookType);

    /*更新书本信息*/
    void  updateBookType(TBookType tBookType);
}