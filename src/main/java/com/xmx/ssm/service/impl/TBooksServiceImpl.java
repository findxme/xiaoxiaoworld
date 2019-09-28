package com.xmx.ssm.service.impl;

import com.xmx.ssm.dao.TBookMapper;
import com.xmx.ssm.entity.TBook;
import com.xmx.ssm.service.TBooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TBooksServiceImpl implements TBooksService {
    @Autowired
    TBookMapper tBookMapper;


    @Override
    public List<TBook> findBooksAll() {
        return null;
    }

    @Override
    public void deleteBooksNo(TBook tBook) {

    }

    @Override
    public void insertBook(TBook tBook) {

    }

    @Override
    public void updateBook(TBook tBook) {

    }

    @Override
    public List<TBook> findBooksOne(TBook tBook) {
        return null;
    }
}
