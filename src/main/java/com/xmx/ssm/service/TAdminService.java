package com.xmx.ssm.service;

import com.xmx.ssm.entity.TAdmin;

import java.util.List;

public interface TAdminService {

    List<TAdmin> findAll();

    TAdmin findAdminByName(String adminName);

    TAdmin findAdminByNo(String adminNo);
}
