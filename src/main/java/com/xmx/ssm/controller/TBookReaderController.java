package com.xmx.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.xmx.ssm.service.TBookReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/tBookReader")
public class TBookReaderController {

    @Autowired
    private TBookReaderService tBookReaderService;

    @RequestMapping("/bookInfoPage")
    public String bookInfo(){
        return "book_reader/bookInfo";
    }

    @RequestMapping("/books")
    @ResponseBody
    public JSONObject getBookInfo(){

        return null;
    }

}
