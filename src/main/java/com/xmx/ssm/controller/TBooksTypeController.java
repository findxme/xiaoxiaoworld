package com.xmx.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.xmx.ssm.entity.TBook;
import com.xmx.ssm.entity.TBookType;
import com.xmx.ssm.service.TBooksTypeService;
import com.xmx.ssm.util.PageLimit;
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


    /*
     * 返回表格数据
     * */
    @ResponseBody
    @RequestMapping("/findBooksTypeAll")
    public JSONObject findBooksAll(int page, int limit) {
        int currIndex = (page - 1) * limit;
        List<Map<String, Object>> books = tBooksTypeService.findBooksTypeLimit(currIndex, limit);
        JSONObject json = PageLimit.layuiJson(0, "", tBooksTypeService.countByExample(), books);
        return json;
    }

    /*查找有多少条数据*/
    @ResponseBody
    @RequestMapping("/countByExample")
    public ModelAndView countByExample() {
        return null;
    }


    /*根据查找书本类型*/
    @ResponseBody
    @RequestMapping("/selectBooksTypeOne")
    public int selectBooksTypeOne(String no) {
        TBookType tBookType = new TBookType();
        tBookType.setbBookTypeNo(no);
        List<Map<String, Object>> maps = tBooksTypeService.selectBooksTypeOne(tBookType);
        if (maps.size() == 0) {
            return 0;
        }
        return 1;
    }

    /*查询全部*/
    @ResponseBody
    @RequestMapping("/selectBooksType")
    public ModelAndView selectBooksType() {
        return null;
    }


    /*增加书本类型*/
    @ResponseBody
    @RequestMapping("/insertTBookType")
    public void insertTBookType(String no, String type) {
        TBookType tBookType = new TBookType();
        tBookType.setbBookTypeNo(no);
        tBookType.setbBookType(type);
        tBooksTypeService.insertTBookType(tBookType);

    }

    /*删除书本类型*/
    @ResponseBody
    @RequestMapping("/deleteBooksType")
    public int deleteBooksType(String id) {
        TBookType tBookType = new TBookType();
        tBookType.setbBookTypeNo(id);

        try {
            tBooksTypeService.deleteBooksType(tBookType);
        } catch (Exception e) {

            return 0;
        }
        return 1;
    }



    @RequestMapping("/bookTypeUpdate")
    public  void  bookTypeUpdate(String no,String type){
        System.err.println(no+","+type);
        TBookType tBookType = new TBookType();
        tBookType.setbBookTypeNo(no);
        tBookType.setbBookType(type);

        tBooksTypeService.updateBookType(tBookType);
    }

    @RequestMapping("/booksType")
    public String booksType() {
        return "book/type/type_list";
    }

    @RequestMapping("/typeAddView")
    public String typeAddView() {
        return "book/type/type_listform_add";
    }

    @RequestMapping("/typeUpdateView")
    public ModelAndView typeUpdateView(String id, ModelAndView modelAndView) {
        TBookType tBookType = new TBookType();
        tBookType.setbBookTypeNo(id);
        List<Map<String, Object>> maps = tBooksTypeService.selectBooksTypeOne(tBookType);
        modelAndView.addObject("type", maps.get(0));
        modelAndView.setViewName("book/type/type_listform_update");
        return modelAndView;
    }
}
