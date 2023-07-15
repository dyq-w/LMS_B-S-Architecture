package com.dyq.bookmgr.mapper;

import com.dyq.bookmgr.dao.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author dtdyq
 * @create 2022-03-21 16:30
 **/
@Component
@Mapper
public interface BookMapper {

    @Select("select * from book")
    @Results({
        @Result(property = "publicTime",column = "public_time")
    })
    List<Book> selectAll();

    @Select("select * from book where name like #{name}")
    List<Book> selectByNamePattern(String name);

    @Insert("insert into book(name,author,press,public_time,category,site,reserve) values(#{name},#{author},#{press},#{publicTime},#{category},#{site},#{reserve});")
    void insertOne(Book book);

    @Select("SELECT * FROM `book` where id = #{id}")
    Book selectById(int id);

    //根据书的ID来修改库存的数量
    @Update("UPDATE book set reserve = #{param1} where id = #{param2}")
    void updateReserve(int reserve,int id);

    @Select("select * from book where id >= (select id from book order by id limit #{param1}, 1) limit #{param2}")
    @Results({
            @Result(property = "publicTime",column = "public_time")
    })
    List<Book> selectByPage(int m, int n);

    @Select("select count(*) from book")
    int selectCount();

    //通过书名和作者查询ID
    @Select("select * from book where name=#{param1} and author = #{param2}")
    Book selectBookByNa(String name,String author);

    @Update("UPDATE book SET reserve = #{param1},rate = #{param2} where id = #{param3}")
    void updateReserveRateById(int reserve,double rate,int id);

    //查询前五十条数据（按评分序）
    @Select("select * from book order by rate desc limit 0,50")
    @Results({
            @Result(property = "publicTime",column = "public_time")
    })
    List<Book> selectRateOrder();

    //查询前五十条数据（按库存序）
    @Select("select * from book order by reserve desc limit 0,50")
    @Results({
            @Result(property = "publicTime",column = "public_time")
    })
    List<Book> selectReserveOrder();

    //查询前五十条数据（按出版时间序）
    @Select("select * from book order by public_time desc limit 0,50")
    @Results({
            @Result(property = "publicTime",column = "public_time")
    })
    List<Book> selectPublicTimeOrder();

    @Update("UPDATE book set site = #{param1},reserve=#{param2} where id=#{param3}")
    void updateSiteReserve(String site,int reserve,int id);

    @Select("SELECT * FROM `book` where name=#{param1}")
    @Results({
            @Result(property = "publicTime",column = "public_time")
    })
    List<Book> selectBookByName(String name);

    @Select("SELECT * FROM `book` where author=#{param1}")
    @Results({
            @Result(property = "publicTime",column = "public_time")
    })
    List<Book> selectBookByAuthor(String author);

    @Select("SELECT * FROM `book` where press=#{param1}")
    @Results({
            @Result(property = "publicTime",column = "public_time")
    })
    List<Book> selectBookByPress(String press);

    @Select("SELECT * FROM `book` where category like #{param1}")
    @Results({
            @Result(property = "publicTime",column = "public_time")
    })
    List<Book> selectBookByCategory(String category);

    @Select("SELECT * FROM `book` where reserve=#{param1}")
    @Results({
            @Result(property = "publicTime",column = "public_time")
    })
    List<Book> selectBookByReserve(int reserve);

    @Delete("DELETE FROM book WHERE id = #{param1}")
    void deletebook(int id);
}
