package com.dyq.bookmgr.service;


import com.dyq.bookmgr.dao.User;
import com.dyq.bookmgr.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/getusers")
    public List<User> getUsers(){
        return userMapper.selectAll();
    }

    @RequestMapping("/changeusermessage")
    @ResponseBody
    public int changeUserMessage(@RequestBody User user){

        userMapper.updatePswRole(user.getPassword(),user.getRole(),user.getId());
        return 0;
    }

    @RequestMapping("/changeownmessage")
    @ResponseBody
    public int changeOwnMessage(@RequestBody User user){
        userMapper.updateUserByOwn(user.getName(),user.getPassword(),user.getAge(),user.getEmail(),user.getAdress(),user.getId());
        return 0;
    }

    @GetMapping("/getchangeownmessage")
    public User getChangeOwnMessage(@RequestParam("id") int id){
        return userMapper.selectById(id);
    }

}
