package com.xmx.ssm.service.impl;

import com.xmx.ssm.dao.TAdminMapper;
import com.xmx.ssm.entity.TAdmin;
import com.xmx.ssm.entity.TAdminExample;
import com.xmx.ssm.service.TAdminService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TAdminServiceImpl implements TAdminService {
    @Autowired
    private TAdminMapper tAdminMapper;

    @Override
    public List<TAdmin> findAll(){
        TAdminExample tAdminExample = new TAdminExample();
        tAdminExample.setDistinct(false);
        tAdminExample.setOrderByClause("order");
        return tAdminMapper.selectByExample(tAdminExample);
    }
}
