package com.xmx.ssm.dao;

import com.xmx.ssm.entity.TBook;
import com.xmx.ssm.entity.TBookExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TBookMapper {
    /*ok*/
     /*查出有多少条记录*/
    long countByExample();

    /**
     * 分页查询
     * @param currIndex
     * @param pageSize
     * @return
     */
    @Select("select * from t_book  limit #{currIndex},#{pageSize}")
    List<Map<String ,Object>> findBooksLimit(@Param("currIndex") int currIndex,@Param("pageSize") int pageSize);

    /*查找全部*/
    List<Map<String ,Object>> findBooksAll();

    /*ok*/
    /*条件查询*/
    List<Map<String ,Object>> findBooksOne(TBook tBook);

    /*ok*/
    /*根据主键查找数据 nook*/
    TBook selectByPrimaryKey(@Param("bBookNo") String bBookNo);


    /*ok*/
    /*增加啊书本信息 图书编号，图书书名，作何，书店类型，书的入库时间，必填ok*/
    int insertBooks(TBook record);

    /*ok*/
    /*根据no建插入信息，作者，书店类型，书的入库时间，必填ok*/
    int insertSelective(TBook record);


    /*ok*/
    /* 根据no字段更新数据ok*/
    int updateByExample( TBook record);

    /*ok*/
    /*根据no字段删除*/
    int deleteByTBook(TBook tBook);

    /*查出每种数的类型有多少本 数量字段名quantity*/
    List<Map<String,Object>> countBooksTypeQuantity();


}