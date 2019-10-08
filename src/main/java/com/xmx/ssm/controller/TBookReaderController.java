package com.xmx.ssm.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.xmx.ssm.service.TBookReaderService;
import com.xmx.ssm.service.TBooksService;
import com.xmx.ssm.util.PageLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tBookReader")
public class TBookReaderController {

    @Autowired
    private TBookReaderService tBookReaderService;

    @Autowired
    private TBooksService tBooksService;

    @RequestMapping("/bookInfoPage")
    public String bookInfo(){
        return "book_reader/bookInfo";
    }


//    JSONObject json = new JSONObject();

    /**
     * 借阅信息分页查询
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping("/books")
    @ResponseBody
    public JSONObject getBookInfo(int page,int limit){

//        System.err.println(tBookReaderService.findAll());

        List<Map<String,Object>> list =  tBookReaderService.pagingInfo(page,limit);
//        System.err.println(PageLimit.layuiJson(0,"",tBookReaderService.countInfos(),list));
        return PageLimit.layuiJson(0,"",tBookReaderService.countInfos(),list);
    }

//    @RequestMapping("/manageReaderAndBook")
//    public JSONObject manageReaderAndBook(){
//
//    }

}
