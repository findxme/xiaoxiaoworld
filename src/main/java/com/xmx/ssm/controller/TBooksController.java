package com.xmx.ssm.controller;


import com.alibaba.fastjson.JSONObject;
import com.xmx.ssm.dao.TBookMapper;
import com.xmx.ssm.entity.TBook;
import com.xmx.ssm.service.TBooksService;
import com.xmx.ssm.util.PageLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user2")
public class TBooksController {

    @Autowired
    TBooksService tBooksService;

    @Autowired
    TBookMapper tBookMapper;


    @ResponseBody
    @RequestMapping("/test")
    public JSONObject findBooksAll() {
        int page=2;//页面号
        int limit=3;//单页显示数据长度
//        page limit
        int currIndex = (page - 1) * limit;

        List<Map<String, Object>> booksAll = tBookMapper.findBooksLimit(currIndex, limit);

       JSONObject json=  PageLimit.layuiJson(0,"", tBookMapper.countByExample(),booksAll);
       
        return json;
    }

    public void deleteBooksNo(TBook tBook) {

    }


    public void insertBook(TBook tBook) {

    }


    public void updateBook(TBook tBook) {

    }


    public List<TBook> findBooksOne(TBook tBook) {
        return null;
    }


}
