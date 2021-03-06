package com.xmx.ssm.service.impl;

import com.xmx.ssm.dao.TReaderMapper;
import com.xmx.ssm.entity.TReader;
import com.xmx.ssm.service.TReadersService;
import org.apache.ibatis.annotations.One;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TReadersServiceImpl implements TReadersService {



    @Autowired
    private TReaderMapper tReaderMapper;

    @Override
    public long countByExample() {
        return tReaderMapper.countByExample();
    }

    @Override
    public List<Map<String, Object>> findReaderLimit(int currIndex, int pageSize) {
        return tReaderMapper.findReaderLimit(currIndex,pageSize);
    }

    @Override
    public List<Map<String ,Object>> findReaderOne(String name) {
        return tReaderMapper.findReaderOne(name);
    }

    @Override
    public List<Map<String, Object>> findReaderNameOne(String name) {
        return tReaderMapper.findReaderNameOne(name);
    }

    @Override
    public List<Map<String, Object>> findReadersAll() {
        return null;
    }

    @Override
    public int deleteReadersNo(TReader tReader) {
        return tReaderMapper.deleteByNo(tReader);
    }

    @Override
    public int insertReader(TReader tReader) {
        return tReaderMapper.insert(tReader);
    }

    @Override
    public int updateReader(TReader tReader) {
        return  tReaderMapper.updateByNo(tReader);
    }

    @Override
    public int updateByName(TReader tReader) {
        return tReaderMapper.updateByName(tReader);
    }

    @Override
    public List<TReader> findReadersOne(TReader tReader) {
        return null;
    }



    @Override
    public TReader findReaderByNo(String readerNo){
        return tReaderMapper.findReaderByNo(readerNo);
    }

    @Override
    public TReader findReaderByName(String readerName){
        if(tReaderMapper.findReaderByName(readerName)==null){
            return null;
        }
        return tReaderMapper.findReaderByName(readerName);
    }

    @Override
    public int insertReaderSelective(TReader tReader) {
        return tReaderMapper.insertSelective(tReader);
    }
}
