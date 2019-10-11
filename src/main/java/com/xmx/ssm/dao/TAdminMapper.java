package com.xmx.ssm.dao;

import com.xmx.ssm.entity.TAdmin;
import com.xmx.ssm.entity.TAdminExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TAdminMapper {

    TAdmin findAdminByNo(@Param("bAdminNo")String bAdminNo);

    long countByExample(TAdminExample example);

    int deleteByExample(TAdminExample example);

    TAdmin findAdminByName(@Param("bAdminName")String bAdminNo);

    int insert(TAdmin record);

    int insertSelective(TAdmin record);

    List<TAdmin> selectByExample(TAdminExample example);

    int updateByExampleSelective(@Param("record") TAdmin record, @Param("example") TAdminExample example);

    int updateByExample(@Param("record") TAdmin record, @Param("example") TAdminExample example);
}