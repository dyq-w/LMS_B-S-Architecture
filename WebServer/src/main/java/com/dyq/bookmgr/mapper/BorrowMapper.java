package com.dyq.bookmgr.mapper;

import com.dyq.bookmgr.dao.Borrow;
import com.dyq.bookmgr.dao.BorrowBook;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Mapper
public interface BorrowMapper {
    @Insert("insert into borrow_record(user_id,book_id,begin_time,borrow_time,return_time,count) values(#{user_id},#{book_id},#{begin_time},#{borrow_time},#{return_time},#{count})")
    void insertOne(Borrow borrow);


    @Select("select * from (select borrow_record.user_id,borrow_record.begin_time,borrow_record.return_time,borrow_record.count,book.`name`,book.author,book.rate from borrow_record left join book on borrow_record.book_id = book.id)as a where user_id = #{user_id}")
    @Results({
            @Result(property = "beginTime",column = "begin_time"),
            @Result(property = "returnTime",column = "return_time")
    })
    List<BorrowBook> selectUserBorrowBook(int user_id);

    @Delete("DELETE from borrow_record where user_id = #{param1} and return_time = #{param2} and book_id = #{param3}")
    void deleteByUserReturnTime(int user_id,long return_time,int book_id);
}
