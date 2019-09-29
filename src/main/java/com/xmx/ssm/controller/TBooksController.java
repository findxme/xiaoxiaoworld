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
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tBooks")
public class TBooksController {

    @Autowired
    TBooksService tBooksService;


    /*查出有多少条记录*/
    @ResponseBody
    @RequestMapping("/findBooksAll")
    public ModelAndView findBooksAll() {
//        int page=2;//页面号
//        int limit=3;//单页显示数据长度
//        page limit
//        int currIndex = (page - 1) * limit;
//
//        List<Map<String, Object>> booksAll = tBookMapper.findBooksLimit(currIndex, limit);

//       JSONObject json=  PageLimit.layuiJson(0,"", tBookMapper.countByExample(),booksAll);

       // return json;
    ModelAndView view =new ModelAndView("book/book_list");
        return view;
    }

    /*条件查询*/
    @ResponseBody
    @RequestMapping("/findBooksOne")
    public ModelAndView findBooksOne(){
        return null;
    }

    /*根据主键查找数据 nook*/
    @ResponseBody
    @RequestMapping("/selectByPrimaryKey")
    public ModelAndView selectByPrimaryKey(){
        return null;
    }


    /*增加啊书本信息 图书编号，图书书名，作何，书店类型，书的入库时间，必填ok*/
    @ResponseBody
    @RequestMapping("/insertBooks")
    public ModelAndView insertBooks(){
        return null;
    }


    /* 根据no字段更新数据ok*/
    @ResponseBody
    @RequestMapping("/updateByExample")
    public ModelAndView updateByExample(){
        return null;
    }



    /*根据no字段删除*/
    @ResponseBody
    @RequestMapping("/deleteByTBook")
    public ModelAndView deleteByTBook(){
        return null;
    }

    /*查出每种数的类型有多少本 数量字段名quantity*/
    @ResponseBody
    @RequestMapping("/countBooksTypeQuantity")
    public ModelAndView countBooksTypeQuantity(){
        return null;
    }

    /*根据no建插入信息，作者，书店类型，书的入库时间，必填ok*/
    @ResponseBody
    @RequestMapping("/insertSelective")
    public ModelAndView insertSelective(){
        return null;
    }




    @ResponseBody
    @RequestMapping("/booksType")
    public ModelAndView test() {


        // return json;
        ModelAndView view =new ModelAndView("book/type/type_list");
        return view;
    }

    @RequestMapping("/book_listform_add")
    public ModelAndView test2() {


        // return json;
        ModelAndView view =new ModelAndView("book/book_listform_add");
        return view;
    }



}
