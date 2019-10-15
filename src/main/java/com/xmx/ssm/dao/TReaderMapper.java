package com.xmx.ssm.dao;

import com.xmx.ssm.entity.TReader;
import com.xmx.ssm.entity.TReaderExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TReaderMapper {
    long countByExample();



    /**
     * 分页查询
     * @param currIndex
     * @param pageSize
     * @return
     */
    @Select("select * from t_reader limit #{currIndex},#{pageSize}")
    List<Map<String ,Object>> findReaderLimit(@Param("currIndex") int currIndex, @Param("pageSize") int pageSize);

    @Select("select * from t_reader where b_reader_no=#{no}")
    List<Map<String ,Object>> findReaderOne(String no);

    @Select("select * from t_reader where b_reader_name=#{name}")
    List<Map<String ,Object>> findReaderNameOne(String name);

    TReader findReaderByName(@Param("readerName")String readerName);

    TReader findReaderByNo(@Param("readerNo")String readerNo);

    int deleteByExample(TReaderExample example);

    int deleteByPrimaryKey(@Param("bReaderId") Integer bReaderId, @Param("bReaderNo") String bReaderNo, @Param("bReaderName") String bReaderName, @Param("bReaderEmail") String bReaderEmail);

    int deleteByNo(TReader tReader);

    int insert(TReader record);

    int insertSelective(TReader record);

    List<TReader> selectByExample(TReaderExample example);

    TReader selectByPrimaryKey(@Param("bReaderId") Integer bReaderId, @Param("bReaderNo") String bReaderNo, @Param("bReaderName") String bReaderName, @Param("bReaderEmail") String bReaderEmail);

    int updateByExampleSelective(@Param("record") TReader record, @Param("example") TReaderExample example);

    int updateByExample(@Param("record") TReader record, @Param("example") TReaderExample example);

    int updateByPrimaryKeySelective(TReader record);

    int updateByNo(TReader record);

    int updateByName(TReader record);
}