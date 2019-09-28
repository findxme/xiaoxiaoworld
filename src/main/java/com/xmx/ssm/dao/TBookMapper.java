package com.xmx.ssm.dao;

import com.xmx.ssm.entity.TBook;
import com.xmx.ssm.entity.TBookExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TBookMapper {
     /*查出有多少条记录*/
    long countByExample(TBookExample example);

    int deleteByExample(TBookExample example);

    int deleteByPrimaryKey(@Param("bBookId") Integer bBookId, @Param("bBookNo") String bBookNo);

    int insert(TBook record);

    int insertSelective(TBook record);

    List<TBook> selectByExample(TBookExample example);

    TBook selectByPrimaryKey(@Param("bBookId") Integer bBookId, @Param("bBookNo") String bBookNo);

    int updateByExampleSelective(@Param("record") TBook record, @Param("example") TBookExample example);

    int updateByExample(@Param("record") TBook record, @Param("example") TBookExample example);

    int updateByPrimaryKeySelective(TBook record);

    int updateByPrimaryKey(TBook record);


    /*查找全部*/
    List<Map<String ,Object>> findBooksAll();

    /*删除书本信息*/
    void deleteBooksNo(TBook tBook);

    /*增加书本信息*/
    void insertBook(TBook tBook);

    /*更新书本信息*/
    void  updateBook(TBook tBook);

    /*条件查询*/
    List<TBook> findBooksOne(TBook tBook);
}