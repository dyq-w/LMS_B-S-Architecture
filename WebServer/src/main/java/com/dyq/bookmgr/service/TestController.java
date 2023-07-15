package com.dyq.bookmgr.service;

import com.dyq.bookmgr.dao.Book;

import java.util.List;

import com.dyq.bookmgr.mapper.BookMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @Autowired
    private BookMapper bookMapper;

    @RequestMapping("/books")
    @ResponseBody
    public List<Book> getBooks(){
        return bookMapper.selectAll();
    }

}
