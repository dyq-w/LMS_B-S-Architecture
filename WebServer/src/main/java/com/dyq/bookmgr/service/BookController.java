package com.dyq.bookmgr.service;

import com.dyq.bookmgr.dao.Book;
import com.dyq.bookmgr.dao.Page;
import com.dyq.bookmgr.mapper.BookMapper;
import com.dyq.bookmgr.model.ServerRet;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author dtdyq
 * @create 2022-03-27 18:16
 **/
@RestController
public class BookController {

    @Autowired
    private BookMapper bookMapper;

    /**
     * 暂时使用书名查询，后面可以加更多
     * @param queryStr query string
     * @return books
     */
    @GetMapping("/bookquery/{queryStr}")
    public List<Book> queryBookByStr(@PathVariable("queryStr") String queryStr) {
        if(queryStr == null || queryStr.length() == 0) {
            return bookMapper.selectAll();
        }else{
            return bookMapper.selectByNamePattern("%"+queryStr.trim()+"%");
        }
    }

    @GetMapping("/getbookbyname")
    public List<Book> getbookbyname(@RequestParam("name") String name){
        return bookMapper.selectBookByName(name);
    }

    @GetMapping("/getbookbyauthor")
    public List<Book> getbookbyauthor(@RequestParam("author") String author){
        return bookMapper.selectBookByAuthor(author);
    }

    @GetMapping("/getbookbypress")
    public List<Book> getbookbypress(@RequestParam("press") String press){
        return bookMapper.selectBookByPress(press);
    }

    @GetMapping("/getbookbycategory")
    public List<Book> getbookbycategory(@RequestParam("category") String category){
        return bookMapper.selectBookByCategory("%"+category+"%");
    }

    @GetMapping("/getbookbyreserve")
    public List<Book> getbookbyreserve(@RequestParam("reserve") int reserve){
        return bookMapper.selectBookByReserve(reserve);
    }

    @GetMapping("/deletebook")
    public int deleteBook(@RequestParam("id") int id){
        bookMapper.deletebook(id);
        return 0;
    }

    @GetMapping("/getCount")
    public int selectCount(){
        return bookMapper.selectCount();
    }

    @GetMapping("/getratebook")
    public List<Book> getRateBook(){
        return bookMapper.selectRateOrder();
    }

    @GetMapping("/getreservebook")
    public List<Book> getreserveBook(){
        return bookMapper.selectReserveOrder();
    }


    @GetMapping("/getpublictimebook")
    public List<Book> getPublicTimeBook(){
        return bookMapper.selectPublicTimeOrder();
    }

    @PostMapping("/bookpagequery")
    @ResponseBody
    public List<Book> bookPageQuery(@RequestBody Page page){
        int m = (page.getCurrentPages()-1)*page.getPageSize();
        int n = page.getPageSize();
        return bookMapper.selectByPage(m,n);
    }

    @PostMapping("/changebook")
    @ResponseBody
    public int changeBook(@RequestBody Book book) {
        if (book.getReserve() < 0) {
            return 1;
        }
        if (!(book.getSite().matches("^([0-9]|[a-zA-Z])+\\-([0-9]|[a-zA-Z])+\\-([0-9]|[a-zA-Z])+$"))) {
            return 2;
        }
        bookMapper.updateSiteReserve(book.getSite(),book.getReserve(),book.getId());
        return 0;
    }


    @PostMapping("/bookinput")
    @ResponseBody
    public ServerRet bookInput(@RequestBody Book book) {
        ServerRet ret = new ServerRet();
        if("".equals(book.getName())){
            ret.setCode(-1);
            ret.setNameerror("please input valid name!");
            return ret;
        }
        if("".equals(book.getAuthor())){
            ret.setCode(-1);
            ret.setAuthorerror("please input correct author!");
            return ret;
        }

        if((book.getPublicTime()) >= System.currentTimeMillis()){
            ret.setCode(-1);
            ret.setPublicTimeerror("please enter the correct publication time!");
            return ret;
        }
        if(!(book.getSite().matches("^([0-9]|[a-zA-Z])+\\-([0-9]|[a-zA-Z])+\\-([0-9]|[a-zA-Z])+$"))){
            ret.setCode(-1);
            ret.setSiteerror("this field cannot be empty!");
            return ret;
        }

        if(book.getReserve() <= 0){
            ret.setCode(-1);
            ret.setReserveerror("please enter the correct receipt quantity!");
            return ret;
        }
        bookMapper.insertOne(book);
        ret.setCode(0);
        return ret;
    }
}
