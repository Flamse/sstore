package com.top.sstore.controller;

import com.top.sstore.pojo.User;
import com.top.sstore.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    /*注册*/
    @PostMapping("/account/join")
    public String  SignUp(User user){
        userService.userRegistration(user);
        return "注册成功";
    }

    /*账户激活*/
    @GetMapping("/account/activate")
    public User activate(User user){
//        System.out.println(user.getUserName()+user.getUserPassword());
        User user1 = userService.updateStatus(user);
        return user1;
    }

    /*登录*/
    @PostMapping("/account/signin")
    public void login(User user){
        userService.userLogin(user);
    }

}
