package com.xmx.ssm.service.impl;

import com.xmx.ssm.dao.TReaderMapper;
import com.xmx.ssm.entity.TReader;
import com.xmx.ssm.service.TReadersService;
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
    public List<Map<String ,Object>> findReaderOne(String no) {
        return tReaderMapper.findReaderOne(no);
    }

    @Override
    public List<Map<String, Object>> findReadersAll() {
        return null;
    }

    @Override
    public void deleteReadersNo(TReader tReader) {

    }

    @Override
    public void insertReader(TReader tReader) {
        tReaderMapper.insert(tReader);
    }

    @Override
    public void updateReader(TReader tReader) {

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
}
