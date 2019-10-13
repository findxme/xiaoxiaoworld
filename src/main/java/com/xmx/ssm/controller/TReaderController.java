package com.xmx.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.xmx.ssm.entity.TReader;
import com.xmx.ssm.service.TReadersService;
import com.xmx.ssm.util.PageLimit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/admin/readerAdmin")
public class TReaderController {
    @Autowired
    private TReadersService tReadersService;




    @ResponseBody
    @RequestMapping("/findReadersAll")
    public JSONObject findReadersAll(int page, int limit) {
        int currIndex = (page - 1) * limit;
        List<Map<String, Object>> readerLimit = tReadersService.findReaderLimit(currIndex, limit);
        JSONObject json = PageLimit.layuiJson(0, "", tReadersService.countByExample(), readerLimit);
        return json;
//    return null;
    }

    @RequestMapping("/reader_listform_update")
    public ModelAndView update(String no, ModelAndView modelAndView) {
        TReader tReader = new TReader();

        List<Map<String, Object>> readersOne = tReadersService.findReaderOne(no);
//        System.err.println(booksOne.get(0));
//        modelAndView.addObject("no", no);
        modelAndView.addObject("reader", readersOne.get(0));
//        List<Map<String, Object>> typeList = tBooksTypeService.selectBooksType();
//        modelAndView.addObject("typeList", typeList);

        modelAndView.setViewName("reader/reader_listform_update");
        return modelAndView;
    }

    /* 根据no字段更新数据ok*/
    @ResponseBody
    @RequestMapping("/updateByExample")
    public void updateByExample(String no, String name, String email, String phone, @RequestParam(value = "remark", defaultValue = "") String remark,String password,int number) {
        TReader tReader = new TReader();
//        tReader.setbBookNo(no);
//        tReader.setbBookName(name);
//        tReader.setbBookAuthor(author);
//        tReader.setbBookNumber(number);
//        tReader.setbBookType(type);
        tReader.setbReaderNo(no);
        tReader.setbReaderName(name);
        tReader.setbReaderEmail(email);
        tReader.setbReaderMobile(phone);
        tReader.setbReaderRemarks(remark);
        tReader.setbReaderPassword(password);
//                    tReader.setbReaderBorrowTime();
        tReader.setbReaderBorrowNumber(number);
        tReader.setbReaderBorrowAlreadyNumber(number);
        System.err.println(tReader);
        tReadersService.updateReader(tReader);
//        System.err.println(no+","+name + "," + author + "," + number + "," + type);
    }

    @RequestMapping("/readerAddView")
    public String readerAddView() {
        return "reader/reader_listform_add";
    }

    @RequestMapping(value = "delete")
    public void deleteReadersNo(TReader tReader) {

    }

    @RequestMapping(value = "add")
    public void insertReader(TReader tReader) {

    }

    @RequestMapping(value = "update")
    public void updateReader(TReader tReader) {

    }

    @RequestMapping("queryOne")
    public ModelAndView findReadersOne(String name) {
        TReader tReader=tReadersService.findReaderByName(name);
        ModelAndView modelAndView = new ModelAndView();
        if (tReader!=null) {
//        List<Map<String, Object>> readerOne = tReadersService.findReaderOne(no);
//        if (readerOne.size() == 0) {
//            return 0;
//
//        }
//        return 1;


            modelAndView.addObject("ReaderInfo", tReader);
            System.out.println(tReader);
            System.out.println(modelAndView);
            modelAndView.setViewName("reader/reader_query");
            return modelAndView;
        }
        else{
            System.out.println("Spare Request!");
            modelAndView.setViewName("reader/test");
            return modelAndView;
        }
//        return "reader/test";
    }

    @RequestMapping("/readerView")
    public String readerView() {
        return "reader/reader_list";
    }


    /*条件查询*/
    @ResponseBody
    @RequestMapping("/findReaderOne")
    public int findReaderOne(String no,String name) {

        List<Map<String, Object>> readerOne = tReadersService.findReaderOne(no);
        if (readerOne.size() == 0) {
            return 0;

        }
        return 1;
    }


    /*根据no字段删除*/
    @ResponseBody
    @RequestMapping("/deleteByTReader")
    public int deleteByTReader(String no) {
        TReader tReader = new TReader();
        tReader.setbReaderNo(no);
        System.err.println(tReader);
        try {
            tReadersService.deleteReadersNo(tReader);
        } catch (Exception e) {

            return 0;
        }
        return 1;
//        return null;
    }

    @ResponseBody
    @RequestMapping("/insertReade")


        public void insertReade(String no, String name, String email, String phone, @RequestParam(value = "remark", defaultValue = "") String remark,String password,int number) {
                   TReader tReader=new TReader();
            System.err.println(no+","+name+","+email+","+phone+","+remark);
                   tReader.setbReaderNo(no);
                   tReader.setbReaderName(name);
                    tReader.setbReaderEmail(email);
                    tReader.setbReaderMobile(phone);
                    tReader.setbReaderRemarks(remark);
                    tReader.setbReaderPassword(password);
//                    tReader.setbReaderBorrowTime();
                    tReader.setbReaderBorrowNumber(number);
                    tReader.setbReaderBorrowAlreadyNumber(number);
                    System.err.println(tReader);
                    tReadersService.insertReader(tReader);

    }


}