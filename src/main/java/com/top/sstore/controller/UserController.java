package com.top.sstore.controller;

import com.sun.deploy.net.HttpResponse;
import com.top.sstore.pojo.User;
import com.top.sstore.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;

@RestController
@RequestMapping("/account")
public class UserController {

    @Autowired
    private IUserService userService;

    /*只能处理当前controller的异常*/
//    @ExceptionHandler(value = Exception.class)
    public String error(Exception e){
        return "error："+e.getMessage();
    }

    /*注册*/
    @PostMapping("/join")
    public String  SignUp(User user){
        userService.userRegistration(user);
        return "注册成功";
    }

    /*账户激活*/
    @GetMapping("/activate")
    public User activate(HttpResponse response, User user){
//        System.out.println(user.getUserName()+user.getUserPassword());
        User user1 = userService.updateStatus(user);

        return user1;
    }

    /*登录*/
    @PostMapping("/signin")
    public User login(User user){
        User user1 = userService.userLogin(user);

//        Session.Cookie cookie = new Session.Cookie();
//        cookie.setName(user1.getUserName());
//        cookie.set

        return user1;
    }

    @GetMapping("/help")
    public String help() throws IllegalAccessException {
        throw new IllegalAccessException("args is empty");
    }


}
