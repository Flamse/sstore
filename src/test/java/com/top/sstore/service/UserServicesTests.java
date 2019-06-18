package com.top.sstore.service;

import com.top.sstore.pojo.User;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServicesTests {

    @Autowired
    private IUserService userService;

    @Test
    public void login(){
        User user = new User();
        user.setUserName("张杰");
        user.setUserPassword("456789");
        user.setUserEmail("1308140539@qq.com");
//        user.setUserPhone("15270476656");
//        String a = userService.userRegistration(user);
        userService.userRegistration(user);
//        System.out.println();
    }

    @Test
    public void checkUserId(){
        System.out.println(userService.checkUserId(5));
        System.out.println(userService.checkUserId(6));
    }

    @Test
    public void userLoginTest(){
        User user = new User();
//        user.setUserName("张登杰");
        user.setUserName("1308140539@qq.com");
        user.setUserPassword(DigestUtils.md5Hex("456789"));
        User user1 = userService.userLogin(user);
        System.out.println(user1.getUserName());
    }

    @Test
    public void finishLogin(){  //激活
        User user = new User();
        user.setUserName("张登杰");
        user.setUserCdk("eb85c1ac24bb4c4ca3425127ae88eaed3e99d24537a84873b2a82e5ac2e7744b");
        userService.updateStatus(user);
        //测试成功
    }

    @Test
    public void showUser(){
        System.out.println(userService.showUserById(1).getUserName());
    }

}
