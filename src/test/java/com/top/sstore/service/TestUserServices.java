package com.top.sstore.service;

import com.top.sstore.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestUserServices {

    @Autowired
    private IUserService userService;

    @Test
    public void login(){
        User user = new User();
        user.setUserName("张鸿");
        user.setUserPassword("123456");
        user.setUserEmail("1048605630@qq.com");
        user.setUserPhone("15270476656");
//        System.out.println(UUIDUtils.getUUID()+user.toString());
        userService.userRegistration(user);
    }

    @Test
    public void finishLogin(){

    }

}
