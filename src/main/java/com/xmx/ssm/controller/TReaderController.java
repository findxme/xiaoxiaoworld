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

    @RequestMapping(value = "queryOne")
    public List<TReader> findReadersOne(TReader tReader) {
        return null;
    }

    @RequestMapping("/readerView")
    public String readerView() {
        return "reader/reader_list";
    }


    /*条件查询*/
    @ResponseBody
    @RequestMapping("/findReaderOne")
    public int findReaderOne(String no) {

        List<Map<String, Object>> readerOne = tReadersService.findReaderOne(no);
        if (readerOne.size() == 0) {
            return 0;
        }
        return 1;
    }

    @ResponseBody
    @RequestMapping("/insertReade")
    public void insertReade(String no, String name, String email, String phone, @RequestParam(value = "remark", defaultValue = "") String remark) {
        System.err.println(no+","+name+","+email+","+phone+","+remark);
    }
}