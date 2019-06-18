package com.top.sstore.service;

import com.top.sstore.dao.OrderMapper;
import com.top.sstore.pojo.Address;
import com.top.sstore.pojo.Cart;
import com.top.sstore.pojo.Service;
import com.top.sstore.service.impl.OrderServiceImpl;
import com.top.sstore.utils.StaticValues;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderTests {
    @Autowired
    private IOrderService orderService;



    @Test
    public void testPushOrder(){
        List<Integer> list=new ArrayList<>();
        list.add(13);
        list.add(14);
//        list.add(3);
        orderService.pushOrder(1,5,list);
    }
}
