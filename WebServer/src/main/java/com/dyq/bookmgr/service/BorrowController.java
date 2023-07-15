package com.dyq.bookmgr.service;


import com.dyq.bookmgr.dao.Book;
import com.dyq.bookmgr.dao.Borrow;
import com.dyq.bookmgr.dao.BorrowBook;
import com.dyq.bookmgr.dao.ReturnBook;
import com.dyq.bookmgr.mapper.BookMapper;
import com.dyq.bookmgr.mapper.BorrowMapper;
import com.dyq.bookmgr.model.BorrowRet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BorrowController {

    @Autowired
    private BorrowMapper borrowMapper;
    @Autowired
    private BookMapper bookMapper;


    @GetMapping("/getpersonalbooks")
    public List<BorrowBook> getPersonalBooks(@RequestParam("user_id") int user_id){
        return borrowMapper.selectUserBorrowBook(user_id);
    }


    @PostMapping("/returnbook")
    @ResponseBody
    public int returnBook(@RequestBody ReturnBook returnBook){
        Book book = bookMapper.selectBookByNa(returnBook.getName(),returnBook.getAuthor());
        int count = book.getReserve() + returnBook.getCount();
        double rate;
        if(book.getRate() == 0.00 ){
            rate = returnBook.getRate();
        }else{
            rate = returnBook.getRate()/10+book.getRate()*0.9;
        }

        bookMapper.updateReserveRateById(count,rate,book.getId());

        borrowMapper.deleteByUserReturnTime(returnBook.getUser_id(),returnBook.getReturnTime(),book.getId());
        return 0;
    }

    @PostMapping("/borrowRecode")
    @ResponseBody
    public BorrowRet borrowRecode(@RequestBody Borrow borrow){
        BorrowRet borrowRet = new BorrowRet();
        borrowRet.setCode(0);
        borrowMapper.insertOne(borrow);
        bookReserveUpdate(borrow.getBook_id(),borrow.getCount());
        return borrowRet;
    }


    private void bookReserveUpdate(int id,int num){
        Book book = bookMapper.selectById(id);
        int reserve = book.getReserve() - num;
        bookMapper.updateReserve(reserve,id);
    }
}
