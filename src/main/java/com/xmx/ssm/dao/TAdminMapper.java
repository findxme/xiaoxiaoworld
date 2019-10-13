package com.xmx.ssm.dao;

import com.xmx.ssm.entity.TAdmin;
import com.xmx.ssm.entity.TAdminExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface TAdminMapper {



    TAdmin findAdminByNo(@Param("bAdminNo")String bAdminNo);

    long countByExample();

    int deleteByExample(TAdminExample example);

    TAdmin findAdminByName(@Param("bAdminName")String bAdminNo);

    int insert(TAdmin record);

    int insertSelective(TAdmin record);

    List<TAdmin> selectByExample(TAdminExample example);

    int updateByExampleSelective(@Param("record") TAdmin record, @Param("example") TAdminExample example);

    int updateByExample(@Param("record") TAdmin record, @Param("example") TAdminExample example);


    @Select("select * from t_admin where b_admin_name=#{username}")
    List<Map<String,Object>> findAdminOne(String username);


    int updateAdmin(TAdmin tAdmin);
}