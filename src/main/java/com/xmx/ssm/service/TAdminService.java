package com.xmx.ssm.service;

import com.xmx.ssm.entity.TAdmin;

import java.util.List;
import java.util.Map;

public interface TAdminService {

    long countByExample();

    List<TAdmin> findAll();

    TAdmin findAdminByName(String adminName);

    TAdmin findAdminByNo(String adminNo);

    int updateAdmin(TAdmin tAdmin);

    List<Map<String,Object>> findAdminOne(String username);

    int insertSelective(TAdmin record);
}
