package com.top.sstore.Study;

import org.springframework.stereotype.Component;

@Component
public class TestAOP {
    public void add(String useranme, String password){
        System.out.println("add [username:"+useranme+",password:"+password+"]");
    }

}
