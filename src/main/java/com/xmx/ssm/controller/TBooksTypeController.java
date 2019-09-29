package com.xmx.ssm.controller;

import com.xmx.ssm.entity.TBookType;
import com.xmx.ssm.service.TBooksTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tBooksType")
public class TBooksTypeController {

    @Autowired
    TBooksTypeService tBooksTypeService;


    /*查找有多少条数据*/
    @ResponseBody
    @RequestMapping("/countByExample")
    public ModelAndView countByExample(){
        return null;
    }


    /*根据查找书本类型*/
    @ResponseBody
    @RequestMapping("/selectBooksTypeOne")
    public ModelAndView selectBooksTypeOne(){
        return null;
    }

    /*查询全部*/
    @ResponseBody
    @RequestMapping("/selectBooksType")
    public ModelAndView selectBooksType(){
        return null;
    }


    /*增加书本类型*/
    @ResponseBody
    @RequestMapping("/insertTBookType")
    public ModelAndView insertTBookType(){
        return null;
    }

    /*删除书本类型*/
    @ResponseBody
    @RequestMapping("/deleteBooksType")
    public ModelAndView deleteBooksType(){
        return null;
    }
}
