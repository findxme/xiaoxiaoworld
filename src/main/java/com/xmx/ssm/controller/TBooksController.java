package com.xmx.ssm.controller;


import com.alibaba.fastjson.JSONObject;
import com.xmx.ssm.entity.TBook;
import com.xmx.ssm.service.TBooksService;
import com.xmx.ssm.util.PageLimit;
import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tBooks")
public class TBooksController {

    @Autowired
    TBooksService tBooksService;

    @RequestMapping("/list")
    public String bookList() {
        return "book/book_list";
    }


    /*查出有多少条记录*/
    @ResponseBody
    @RequestMapping("/findBooksAll")
    public JSONObject findBooksAll(int page, int limit) {

        int currIndex = (page - 1) * limit;
//
        List<Map<String, Object>> books = tBooksService.findBooksLimit(currIndex, limit);

        JSONObject json = PageLimit.layuiJson(0, "", tBooksService.countByExample(), books);

        return json;

//        return view;
    }

    /*条件查询*/
    @ResponseBody
    @RequestMapping("/findBooksOne")
    public ModelAndView findBooksOne() {
        return null;
    }

    /*根据主键查找数据 nook*/
    @ResponseBody
    @RequestMapping("/selectByPrimaryKey")
    public ModelAndView selectByPrimaryKey() {
        return null;
    }


    /*增加啊书本信息 图书编号，图书书名，作何，书店类型，书的入库时间，必填ok*/
    @ResponseBody
    @RequestMapping("/insertBooks")
    public ModelAndView insertBooks() {
        return null;
    }


    /* 根据no字段更新数据ok*/
    @ResponseBody
    @RequestMapping("/updateByExample")
    public ModelAndView updateByExample() {
        return null;
    }


    /*根据no字段删除*/
    @ResponseBody
    @RequestMapping("/deleteByTBook")
    public int deleteByTBook(String id) {
        System.err.println(1);
        System.err.println(id + "  " + 11111);
        System.err.println(2);
        TBook tBook = new TBook();
        tBook.setbBookNo(id);

        try {
            tBooksService.deleteBooksNo(tBook);
        } catch (Exception e) {
            System.err.println("***********************************");
            return 0;
        }
        return 1;
//        return null;
    }

    /*查出每种数的类型有多少本 数量字段名quantity*/
    @ResponseBody
    @RequestMapping("/countBooksTypeQuantity")
    public ModelAndView countBooksTypeQuantity() {
        return null;
    }

    /*根据no建插入信息，作者，书店类型，书的入库时间，必填ok*/
    @ResponseBody
    @RequestMapping("/insertSelective")
    public ModelAndView insertSelective() {
        return null;
    }


    @ResponseBody
    @RequestMapping("/booksType")
    public ModelAndView test() {


        // return json;
        ModelAndView view = new ModelAndView("book/type/type_list");
        return view;
    }

    @RequestMapping("/book_listform_add")
    public ModelAndView test2() {


        // return json;
        ModelAndView view = new ModelAndView("book/book_listform_add");
        return view;
    }


}
