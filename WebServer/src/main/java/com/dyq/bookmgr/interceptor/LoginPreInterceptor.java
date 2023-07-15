package com.dyq.bookmgr.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author dtdyq
 * @create 2022-03-21 20:18
 **/
@Component
public class LoginPreInterceptor implements HandlerInterceptor{
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        String url = request.getRequestURI();
        if (url.endsWith(".js") || url.endsWith(".css") || url.endsWith(".map")) {
            return true;
        }
        if(url.equals("/userinput.html")){
            return true;
        }
        if(url.equals("/userinput")){
            return true;
        }
        Object user = request.getSession().getAttribute("login");
        if (user != null) {
            return true;
        }
        response.sendRedirect("/login.html");
        return false;
    }
}
