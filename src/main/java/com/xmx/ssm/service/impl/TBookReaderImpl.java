package com.xmx.ssm.service.impl;

import com.xmx.ssm.dao.TBookReaderMapper;
import com.xmx.ssm.entity.*;
import com.xmx.ssm.service.TBookReaderService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TBookReaderImpl implements TBookReaderService {
    private static final String notReturn = "未还";
    private static final String alreadyReturn = "已还";
    private static final Integer bRenewFrequency = 3;
    private static final Integer bRenewTime = 30;

    @Autowired
    private TBookReaderMapper tBookReaderMapper;


    @Override
    public Integer countInfos(){
        long counts = tBookReaderMapper.countByExample(new TBookReaderExample());
        return new Long(counts).intValue();
    }


    @Override
    public TBookReader queryInfoByBookReader(String bookNo,String readerNo){
        List<TBookReader> tBookReaders = tBookReaderMapper.queryInfoByBookReaderDate(bookNo, readerNo);
        Iterator<TBookReader> tBookReaderIterator = tBookReaders.iterator();
        TBookReader tBookReader = null;
        while(tBookReaderIterator.hasNext()){
            TBookReader item = tBookReaderIterator.next();
            if("未还".equals(item.getIsReturnBook())){
                tBookReader = item;
            }
        }
        return tBookReader;
    }


    /**
     *
     * @param page  页面号
     * @param pageSize  单页面显示的长度
     * @return
     */
    @Override
    public List<Map<String,Object>> pagingInfo(Integer page,Integer pageSize){
        int currentIndex = (page-1)*pageSize;
        return tBookReaderMapper.pagingInfo(currentIndex,pageSize);
    }

    @Override
    public List<Map<String,Object>> findAll(){
        return tBookReaderMapper.findAll();
    }

    @Override
    public int borrowBook(TBook tBook, TReader tReader){
        System.out.println(tBook.getbBookNo()+","+tReader.getbReaderNo());
        if(tBook.getbBookNo()==null||tReader.getbReaderNo()==null){
            return 0;
        }
        if(this.queryInfoByBookReader(tBook.getbBookNo(),tReader.getbReaderNo())!=null){
            return -2;
        }
        TBookReader tBookReader = new TBookReader();
        tBookReader.setbBorrowDate(new Date());
        tBookReader.setbBookNo(tBook.getbBookNo());
        tBookReader.setbReaderNo(tReader.getbReaderNo());
        tBookReader.setbUserNo("admin1");
        tBookReader.setbOverDate(0);
        tBookReader.setIsReturnBook(notReturn);
        if(tBookReaderMapper.insert(tBookReader)==0){
            return 0;
        }

        //书，读者的书的数量
        int bookNumber = tBook.getbBookNumber();
        if(bookNumber==0){
            return -1;
        }
        tBook.setbBookNumber(--bookNumber);
        int readerBorrowNumber = tReader.getbReaderBorrowNumber();
        int readerAlNum = tReader.getbReaderBorrowAlreadyNumber();
        if(readerBorrowNumber==0){
            return -1;
        }
        tReader.setbReaderBorrowNumber(--readerBorrowNumber);
        tReader.setbReaderBorrowAlreadyNumber(++readerAlNum);

        return tBookReaderMapper.borrowOrReturnBook(tBook,tReader);
    }

    @Override
    public int returnBook(TBook tBook,TReader tReader){
        if(tBook.getbBookNo()==null||tReader.getbReaderNo()==null){
            return 0;
        }
        TBookReader tBookReader = this.queryInfoByBookReader(tBook.getbBookNo(),tReader.getbReaderNo());
        if(tBookReader==null){
            return -2;
        }
        tBookReader.setbReturnDate(new Date());
        tBookReader.setIsReturnBook(alreadyReturn);
        if(tBookReaderMapper.updateByPrimaryKey(tBookReader)==0){
            return 0;
        }
        int bookTotals = tBook.getbBookNumber();
        int readerBook = tReader.getbReaderBorrowNumber();
        int readerHaveBorrowBook = tReader.getbReaderBorrowAlreadyNumber();
        if(readerHaveBorrowBook==0){
            return -1;
        }
        tReader.setbReaderBorrowAlreadyNumber(--readerHaveBorrowBook);
        tReader.setbReaderBorrowNumber(++readerBook);
        System.out.println("readerBook:"+readerBook);
        tBook.setbBookNumber(++bookTotals);
        return tBookReaderMapper.borrowOrReturnBook(tBook,tReader);
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
        TBookReader tBookReader = this.queryInfoByBookReader(tBook.getbBookNo(),tReader.getbReaderNo());
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

    @Override
    public long findReadersBorrowingQuantity() {
        return tBookReaderMapper.findReadersBorrowingQuantity();
    }

    @Override
    public List<Map<String, Object>> selectDay(@Param("currIndex") int currIndex, @Param("pageSize") int pageSize) {
        return tBookReaderMapper.selectDay(currIndex,pageSize);
    }

    @Override
    public long countBydayQuantity() {
        return tBookReaderMapper.countBydayQuantity();
    }

}
