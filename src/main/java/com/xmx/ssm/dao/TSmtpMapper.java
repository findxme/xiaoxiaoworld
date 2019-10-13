package com.xmx.ssm.dao;

import com.xmx.ssm.entity.TSmtp;
import org.apache.ibatis.annotations.Select;

import java.util.Map;

public interface TSmtpMapper {
    @Select("select * from t_smtp")
    Map<String,Object> selectSmtp();

    int updateSmtp(TSmtp tSmtp);
}
