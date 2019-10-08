package com.xmx.ssm.service.impl;

import com.xmx.ssm.dao.TBookTypeMapper;
import com.xmx.ssm.entity.TBookType;
import com.xmx.ssm.service.TBooksTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TBooksTypeServiceImpl implements TBooksTypeService {


    @Autowired
    TBookTypeMapper tBookTypeMapper;

    /*OK*/
    /*查出有多少条记录ok*/
    @Override
    public long countByExample() {
        return tBookTypeMapper.countByExample();
    }

    @Override
    public List<Map<String, Object>> findBooksTypeLimit(int currIndex, int pageSize) {
        return tBookTypeMapper.findBooksTypeLimit(currIndex,pageSize);
    }

    /*ok*/
    /*根据on查找书本类型*/
    @Override
    public List<Map<String, Object>> selectBooksTypeOne(TBookType tBookType) {
        return tBookTypeMapper.selectBooksTypeOne(tBookType);
    }

    /*ok*/
    /*查询全部*/
    @Override
    public List<Map<String ,Object>> selectBooksType(){

        return tBookTypeMapper.selectBooksType();
    }


    /*ok*/
    /*增加书籍信息 需要传入no和type*/
    @Override
    public int insertTBookType(TBookType record) {
        return tBookTypeMapper.insertTBookType(record);
    }


    /*ok*/
    /*删除书本类型*/
    @Override
    public void deleteBooksType(TBookType tBookType) {

        tBookTypeMapper.deleteBooksType(tBookType);
    }

}
