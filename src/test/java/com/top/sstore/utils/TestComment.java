package com.top.sstore.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestComment {

    @Test
    public void getOrderId(){
        Integer orderId=UUID.randomUUID().toString().hashCode();
        System.out.println(orderId);
    }

}
