package com.xmx.ssm.service.impl;

import com.xmx.ssm.dao.TSmtpMapper;
import com.xmx.ssm.entity.TSmtp;
import com.xmx.ssm.service.TSmtpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class TSmtpServiceImpl implements TSmtpService {
    @Autowired
    private TSmtpMapper tSmtpMapper;

    @Override
    public Map<String, Object> selectSmtp() {
        return tSmtpMapper.selectSmtp();
    }

    @Override
    public int updateSmtp(TSmtp tSmtp) {
        return tSmtpMapper.updateSmtp(tSmtp);
    }
}
