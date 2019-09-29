package com.xmx.ssm.service.impl;

import com.xmx.ssm.dao.TBookReaderMapper;
import com.xmx.ssm.entity.*;
import com.xmx.ssm.service.TBookReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
public class TBookReaderImpl implements TBookReaderService {
    private static final String notReturn = "未还";
    private static final String alreadyReturn = "已还";
    private static final Integer bRenewFrequency = 3;
    private static final Integer bRenewTime = 30;

    @Autowired
    private TBookReaderMapper tBookReaderMapper;

    @Override
    public List<Map<String,Object>> findAll(){
        return tBookReaderMapper.findAll();
    }

    @Override
    public int borrowBook(TBook tBook, TReader tReader){
        if(tBook.getbBookNo()==null||tReader.getbReaderNo()==null){
            return 0;
        }
        TBookReader tBookReader = new TBookReader();
        tBookReader.setbBorrowDate(new Date());
        tBookReader.setbBookNo(tBook.getbBookNo());
        tBookReader.setbReaderNo(tReader.getbReaderNo());
        tBookReader.setbUserNo("admin1");
        tBookReader.setbOverDate(0);
        tBookReader.setIsReturnBook(notReturn);
        return tBookReaderMapper.insert(tBookReader);
    }

    @Override
    public int returnBookByNo(TBook tBook, TReader tReader,String borrowDate){
        if(tBook.getbBookNo()==null||tReader.getbReaderNo()==null){
            return 0;
        }
        TBookReader tBookReader = tBookReaderMapper.queryInfoByBookReaderDate(tBook.getbBookNo(),tReader.getbReaderNo(),borrowDate);
        if(tBookReader==null){
            return 0;
        }
        tBookReader.setbReturnDate(new Date());
        tBookReader.setIsReturnBook(alreadyReturn);
        return tBookReaderMapper.updateByPrimaryKey(tBookReader);
    }

    @Override
    public List<TBookReader> findBookByReader(TReader tReader){
        TBookReaderExample example = new TBookReaderExample();
        TBookReaderExample.Criteria criteria = example.createCriteria();
        List<String> list = new ArrayList<>();
        list.add(tReader.getbReaderNo());
        criteria.andBReaderNoIn(list);
        return tBookReaderMapper.selectByExample(example);
    }

    @Override
    public int deleteInfoByNo(TBookReader tBookReader){
        if(isKeyNull(tBookReader)){
            return 0;
        }
        return tBookReaderMapper.deleteByPrimaryKey(
                tBookReader.getbBookReaderId(),
                tBookReader.getbBookNo(),
                tBookReader.getbReaderNo(),
                tBookReader.getbUserNo());
    }


    public boolean isKeyNull(TBookReader tBookReader){
        return tBookReader.getbBookNo()==null||
                tBookReader.getbReaderNo()==null||
                tBookReader.getIsReturnBook()==null||
                tBookReader.getbUserNo()==null;
    }

//    public boolean isOverDate(TBookReader tBookReader){
//        return tBookReader.getbOverDate()==0;
//    }


    /**
     *
     * @param tBook
     * @param tReader
     * @param borrowDate
     *
     * 如果已经续借了三次，就无法再续借
     * @return
     */
    @Override
    public int renewBook(TBook tBook, TReader tReader, String borrowDate){
        TBookReader tBookReader = tBookReaderMapper.queryInfoByBookReaderDate(tBook.getbBookNo(),tReader.getbReaderNo(),borrowDate);
        if(tBookReader==null){
            return 0;
        }
        tBookReader.setbOverDate(0);
        Integer time = tBookReader.getbRenewFrequency();
        if(time==bRenewFrequency){
            return 2;
        }
        tBookReader.setbRenewFrequency(++time);
        tBookReader.setbRenewTime(bRenewTime);
        return tBookReaderMapper.updateByPrimaryKey(tBookReader);
    }

}
