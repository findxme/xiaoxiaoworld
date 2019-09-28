package com.xmx.ssm.controller;


import com.xmx.ssm.entity.TBook;
import com.xmx.ssm.service.TBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/user2")
public class TBooksController {

    @Autowired
    TBooksService tBooksService;


    public List<TBook> findBooksAll() {
        return null;
    }


    public void deleteBooksNo(TBook tBook) {

    }


    public void insertBook(TBook tBook) {

    }


    public void updateBook(TBook tBook) {

    }


    public List<TBook> findBooksOne(TBook tBook) {
        return null;
    }


}
