package com.dyq.bookmgr.mapper;

import com.dyq.bookmgr.dao.User;
import java.util.List;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

@Component
@Mapper
public interface UserMapper {

    @Select("select * from user where role != 1")
    List<User> selectAll();

    @Select("select * from user where name = #{name}")
    User selectByName(String name);

    @Select("select * from user where id = #{id}")
    User selectById(int id);

    @Insert("insert into user(name,password,age,sex,email) values(#{name},#{password},#{age},#{sex},#{email});")
    void insertOne(User user);

    @Update("UPDATE user set password=#{param1},role=#{param2} where id =#{param3}")
    void updatePswRole(String password,int role,int id);

    @Update("UPDATE user set name=#{param1},password=#{param2},age=#{param3},email=#{param4},adress=#{param5} where id = #{param6}")
    void updateUserByOwn(String name,String password,int age,String email,String adress,int id);
}
