package com.xmx.ssm.controller;

import com.xmx.ssm.service.TBooksTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/BooksType")
public class TBooksTypeController {

    @Autowired
    TBooksTypeService tBooksTypeService;

    public void insterBooksType(TBooksTypeService tbooksType) {
    }
}
