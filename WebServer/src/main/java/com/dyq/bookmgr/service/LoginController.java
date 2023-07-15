package com.dyq.bookmgr.service;

import com.dyq.bookmgr.dao.User;
import com.dyq.bookmgr.mapper.UserMapper;
import com.dyq.bookmgr.model.LoginOrRegData;
import com.dyq.bookmgr.model.LoginRet;
import com.dyq.bookmgr.model.RegisterUserRet;
import com.dyq.bookmgr.model.ServerRet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author dtdyq
 * @create 2022-03-21 17:10
 **/
@Controller
public class LoginController {

    private static final Logger LOG = LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/ismanager")
    @ResponseBody
    public boolean isManager(HttpServletRequest request){
        User user = (User) request.getSession().getAttribute("login");
        return user != null && user.getRole() == 1;
    }

    @RequestMapping("/getUser")
    @ResponseBody
    public User getUser(HttpServletRequest request){
        User user = (User)request.getSession().getAttribute("login");
        return user;
    }

    @RequestMapping("/login")
    @ResponseBody
    public LoginRet login(HttpServletRequest request,@RequestBody LoginOrRegData loginOrRegData) {
        LOG.info("login data:{}", loginOrRegData);

        LoginRet ret = checkInput(loginOrRegData, false);
        if (ret.getCode() != 0) {
            return ret;
        }
        User user = userMapper.selectByName(loginOrRegData.getName());
        if (user != null && user.getPassword().equals(loginOrRegData.getPassword())) {
            LOG.info("login success:{}", loginOrRegData);
            request.getSession().setAttribute("login", user);
            return ret;
        } else {
            if (user == null) {
                ret.setCode(-1);
                ret.setNameError("user not exist,please register");
                return ret;
            } else {
                ret.setCode(-1);
                ret.setPasswordError("password incorrect,retry");
                return ret;
            }
        }
    }

    private LoginRet checkInput(LoginOrRegData loginOrRegData, boolean isRegister) {
        LoginRet loginRet = new LoginRet();
        if (!StringUtils.hasLength(loginOrRegData.getName())) {
            loginRet.setCode(-1);
            loginRet.setNameError("please input valid name");
            return loginRet;
        }
        if (!StringUtils.hasLength(loginOrRegData.getPassword())) {
            loginRet.setCode(-1);
            loginRet.setPasswordError("please input valid password");
        }
        if (isRegister && !StringUtils.hasLength(loginOrRegData.getMail()) && !loginOrRegData.getMail().equals("^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$")) {
            loginRet.setCode(-1);
            //todo reg check
            loginRet.setMailError("please input valid mail addr");
        }
        return loginRet;
    }

    @RequestMapping("/userinput")
    @ResponseBody
    public RegisterUserRet userInput(@RequestBody User user) {
        RegisterUserRet ret = new RegisterUserRet();
        if("".equals(user.getName())){
            ret.setCode(-1);
            ret.setNameerror("please input valid name!");
            return ret;
        }
        if("".equals(user.getPassword())){
            ret.setCode(-1);
            ret.setPassworderror("please input a password!");
            return ret;
        }
        if(user.getAge() <= 0){
            ret.setCode(-1);
            ret.setAgeerror("please input valid age!");
            return ret;
        }
        if(!(user.getEmail().matches("^(\\w+([-.][A-Za-z0-9]+)*){3,18}@\\w+([-.][A-Za-z0-9]+)*\\.\\w+([-.][A-Za-z0-9]+)*$"))){
            ret.setCode(-1);
            ret.setEmailerror("please input valid email!");
            return ret;
        }
        userMapper.insertOne(user);
        ret.setCode(0);
        return ret;
    }
}
