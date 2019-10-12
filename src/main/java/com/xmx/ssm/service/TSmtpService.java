package com.xmx.ssm.service;

import com.xmx.ssm.entity.TSmtp;

import java.util.Map;

public interface TSmtpService {

    Map<String, Object> selectSmtp();

    int updateSmtp(TSmtp tSmtp);
}
