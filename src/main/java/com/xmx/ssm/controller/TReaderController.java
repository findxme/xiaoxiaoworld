package com.xmx.ssm.controller;

import com.xmx.ssm.entity.TReader;
import com.xmx.ssm.service.TReadersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/readerAdmin")
public class TReaderController {
    @Autowired
    private TReadersService tReadersService;



    @RequestMapping(value = "queryAll")
    public List<TReader> findReadersAll() {
        return null;
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



}
