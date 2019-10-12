package com.xmx.ssm.service.impl;

import com.xmx.ssm.dao.TAdminMapper;
import com.xmx.ssm.entity.TAdmin;
import com.xmx.ssm.entity.TAdminExample;
import com.xmx.ssm.service.TAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TAdminServiceImpl implements TAdminService {
    @Autowired
    private TAdminMapper tAdminMapper;


    @Override
    public long countByExample() {
        return tAdminMapper.countByExample();
    }

    @Override
    public List<TAdmin> findAll(){
        return tAdminMapper.selectByExample(new TAdminExample());
    }

    @Override
    public TAdmin findAdminByName(String adminName){
        return tAdminMapper.findAdminByName(adminName);
    }

    @Override
    public TAdmin findAdminByNo(String adminNo){
        return tAdminMapper.findAdminByNo(adminNo);
    }

    @Override
    public int updateAdmin(TAdmin tAdmin) {
        return tAdminMapper.updateAdmin(tAdmin);
    }

    @Override
    public List<Map<String,Object>> findAdminOne(String username) {
        return tAdminMapper.findAdminOne(username);
    }

}
