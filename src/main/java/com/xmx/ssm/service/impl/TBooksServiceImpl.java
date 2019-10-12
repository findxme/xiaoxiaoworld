package com.xmx.ssm.service.impl;

import com.xmx.ssm.dao.TBookMapper;
import com.xmx.ssm.entity.TBook;
import com.xmx.ssm.entity.TBookExample;
import com.xmx.ssm.service.TBooksService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class TBooksServiceImpl implements TBooksService {
    @Autowired
    TBookMapper tBookMapper;




    /*OK*/
    /*查找有多少条记录*/
    @Override
    public long  countByExample(){
        return tBookMapper.countByExample();
    }

    @Override
    public long countByBooksTotal() {
        return tBookMapper.countByBooksTotal();

    }

    /*查找全部*/
    @Override
    public List<Map<String, Object>> findBooksAll() {
        return tBookMapper.findBooksAll();
    }
    /**
     * 分页查询
     * @param currIndex
     * @param pageSize
     * @return
     */
    public List<Map<String ,Object>> findBooksLimit(String bookType,Integer currIndex,Integer pageSize){
        return tBookMapper.findBooksLimit(bookType,currIndex,pageSize);
    }

    /*查出每种数的类型有多少本 数量字段名quantity*/
    @Override
    public List<Map<String, Object>> countBooksTypeQuantity() {
        return tBookMapper.countBooksTypeQuantity();
    }
    /*ok*/
    /*查找全部*/
//    @Override
//    public  List<Map<String ,Object>> findBooksAll() {
//        System.out.println(123);
////        return null;
//        return tBookMapper.findBooksAll();
//    }


    /*OK*/
    /*条件查询 ok*/
    @Override
    public   List<Map<String ,Object>> findBooksOne(TBook tBook) {
        return tBookMapper.findBooksOne(tBook);
    }


    /*OK*/
    /*根据主键查找数据*/
    public TBook selectByPrimaryKey(String bBookNo){
        return  tBookMapper.selectByPrimaryKey(bBookNo);
    }


    /*OK*/
    /*增加啊书本信息 图书编号，图书书名，作者，书店类型，书的入库时间，必填ok*/
    @Override
    public int insertBooks(TBook record) {
        return tBookMapper.insertBooks(record);
    }

    /*OK*/
    /*根据no建插入信息，作者，书店类型，书的入库时间，必填*/
    @Override
    public int insertSelective(TBook record) {
        return tBookMapper.insertSelective(record);
    }


    /*ok*/
    /* 根据no字段更新数据*/
    @Override
    public int updateByExample(TBook record) {
        return tBookMapper.updateByExample(record);
    }

    /*ok*/
    /*删除书本信息*/
    @Override
    public void deleteBooksNo(TBook tBook) {
        tBookMapper.deleteByTBook(tBook);
    }









}
