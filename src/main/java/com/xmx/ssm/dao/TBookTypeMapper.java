package com.xmx.ssm.dao;

import com.xmx.ssm.entity.TBookType;
import com.xmx.ssm.entity.TBookTypeExample;
import java.util.List;
import java.util.Map;

import com.xmx.ssm.service.TBooksTypeService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TBookTypeMapper {

    /*ok*/
    /*查找有多少条数据*/
    long countByExample();


    /**
     * 分页查询
     * @param currIndex
     * @param pageSize
     * @return
     */
    @Select("select * from t_book_type  limit #{currIndex},#{pageSize}")
    List<Map<String ,Object>> findBooksTypeLimit(@Param("currIndex") int currIndex,@Param("pageSize") int pageSize);

    /*ok*/
    /*根据查找书本类型*/
    List<Map<String ,Object>> selectBooksTypeOne(TBookType tBookType);

     /*ok*/
    /*查询全部*/
    List<Map<String ,Object>> selectBooksType();

    /*增加书本类型*/
    int insertTBookType(TBookType record);

    /*删除书本类型*/
    void deleteBooksType(TBookType tBookType);

}