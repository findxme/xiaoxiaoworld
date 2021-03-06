package com.xmx.ssm.controller;


import com.alibaba.fastjson.JSONObject;
import com.xmx.ssm.entity.TBook;
import com.xmx.ssm.service.TBooksService;
import com.xmx.ssm.service.TBooksTypeService;
import com.xmx.ssm.util.PageLimit;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/tBooks")
public class TBooksController {

    @Autowired
    TBooksService tBooksService;

    @Autowired
    TBooksTypeService tBooksTypeService;

    @RequestMapping("/list")
    public String bookList(Model model) {
        return "book/book_list";
    }


    /*
     * 返回表格数据
     * */
    @ResponseBody
    @RequestMapping("/findBooksAll")
    public JSONObject findBooksAll(@Param("keyWord") String keyWord, @Param("bookType") String bookType, Integer page, Integer limit) {
        if ("".equals(bookType)) {
            bookType = null;
        }
        int currIndex = (page - 1) * limit;
        List<Map<String, Object>> books = tBooksService.findBooksLimit(keyWord, bookType, currIndex, limit);
        System.out.println("bookSize:" + books.size());
        JSONObject json = PageLimit.layuiJson(0, "", tBooksService.countByExample(), books);
        return json;
    }

    @RequestMapping("/goodslist")
    public String goodslist() {
        return "template/goodslist";
    }


    @ResponseBody
    @RequestMapping("/findBooksNo")
    public int findBooksNo(String no) {
        TBook tBook = new TBook();
        tBook.setbBookNo(no);
        if (tBooksService.findBooksOne(tBook).size() > 0) {
            return 1;
        }
        return 0;
    }

    /*条件查询*/
    /*动态sql*/
    @ResponseBody
    @RequestMapping("/findBooksOne")
    public JSONObject findBooksOne(@Param("bookNo") String bookNo,
                                   @Param("bookName") String bookName,
                                   @Param("bookAuthor") String bookAuthor,
                                   @Param("bookType") String bookType,
                                   Integer page,
                                   Integer limit) {
        if ("".equals(bookType)) {
            bookType = null;
        }
        int currIndex = (page - 1) * limit;
        List<Map<String, Object>> booksOne = tBooksService.findBooksAll(bookNo, bookName, bookAuthor, bookType, currIndex, limit);

        return PageLimit.layuiJson(0, "", tBooksService.countByExample(), booksOne);
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
    public void updateByExample(String no, String name, String author, int number, String type) {
        TBook tBook = new TBook();
        tBook.setbBookNo(no);
        tBook.setbBookName(name);
        tBook.setbBookAuthor(author);
        tBook.setbBookNumber(number);
        tBook.setbBookType(type);
        tBooksService.updateByExample(tBook);

    }


    /*根据no字段删除*/
    @ResponseBody
    @RequestMapping("/deleteByTBook")
    public int deleteByTBook(String id) {
        TBook tBook = new TBook();
        tBook.setbBookNo(id);

        try {
            tBooksService.deleteBooksNo(tBook);
        } catch (Exception e) {

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
    public void insertSelective(String no, String name, String author, int number, String type) {
        TBook tBook = new TBook();
        tBook.setbBookNo(no);
        tBook.setbBookName(name);
        tBook.setbBookAuthor(author);
        tBook.setbBookNumber(number);
        tBook.setbBookType(type);
        tBook.setbBookCreatedate(new Date());

        System.err.println(tBook);

        tBooksService.insertBooks(tBook);

//        System.err.println(no + "," + name + "," + author + "," + number + "," + type);
    }


    @ResponseBody
    @RequestMapping("/booksType")
    public ModelAndView test() {

        // return json;
        ModelAndView view = new ModelAndView("book/type/type_list");
        return view;
    }

    @RequestMapping("/book_listform_add")
    public ModelAndView test2(ModelAndView modelAndView) {
        List<Map<String, Object>> typeList = tBooksTypeService.selectBooksType();
        System.err.println(typeList);
        modelAndView.addObject("typeList", typeList);
        modelAndView.setViewName("book/book_listform_add");
        return modelAndView;
    }

    @RequestMapping("/book_listform_update")
    public ModelAndView update(String id, ModelAndView modelAndView) {
        TBook tBook = new TBook();
        tBook.setbBookNo(id);
        List<Map<String, Object>> booksOne = tBooksService.findBooksOne(tBook);

        modelAndView.addObject("book", booksOne.get(0));

        List<Map<String, Object>> typeList = tBooksTypeService.selectBooksType();
        modelAndView.addObject("typeList", typeList);
        modelAndView.setViewName("book/book_listform_update");
        return modelAndView;
    }

}
