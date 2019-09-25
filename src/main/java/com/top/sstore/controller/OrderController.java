package com.top.sstore.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.top.sstore.pojo.Order;
import com.top.sstore.pojo.Orderitem;
import com.top.sstore.pojo.Picture;
import com.top.sstore.pojo.Service;
import com.top.sstore.service.IOrderService;
import com.top.sstore.service.IPictureService;
import com.top.sstore.service.IServiceService;
import com.top.sstore.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;
    @Autowired
    private IServiceService serviceService;
    @Autowired
    private IPictureService pictureService;

    @GetMapping("/push")
    public Message s_push(Integer addressId, Integer[] cartIds, HttpSession session){
        List<Integer> list = Arrays.asList(cartIds);
        if (addressId == null)
            return Message.fail();
        Integer userId = (Integer) session.getAttribute("userAccountId");
        boolean b = orderService.pushOrder(addressId, userId, list);
        if (b)
            return Message.success();
        return Message.fail();
    }

    @GetMapping("/pay")
    public Message s_pay(Integer orderId, HttpSession session){
        Integer userId = (Integer)session.getAttribute("userAccountId");
        boolean b = orderService.payOrder(orderId, userId);
        if (b)
            return Message.success();
        return Message.fail();
    }

    @GetMapping("/distribute")
    public Message s_distribute(Integer orderId, HttpSession session){
        Integer userId = (Integer)session.getAttribute("userAccountId");
        boolean b = orderService.distributeOrder(orderId, userId);
        if (b)
            return Message.success();
        return Message.fail();
    }

    @GetMapping("/complete")
    public Message s_complete(Integer orderId, HttpSession session){
        Integer userId = (Integer)session.getAttribute("userAccountId");
        boolean b = orderService.completeOrder(orderId, userId);
        if (b){
            return Message.success();
        }
        return Message.fail();
    }

    @GetMapping("/cancel")
    public Message s_cancel(Integer orderId, HttpSession session){
        Integer userId = (Integer)session.getAttribute("userAccountId");
        boolean b = orderService.cancelOrder(orderId, userId);
        if (b)
            return Message.success();
        return Message.fail();
    }

    @GetMapping("/show")
    public Message s_show(HttpSession session){
        Integer userId = (Integer)session.getAttribute("userAccountId");
        List<Order> orders= orderService.selectOrderOfAll(userId);
        return Message.success().add("orders", orders);
    }

    @GetMapping("/showOrder")
    public Message s_showOne(Integer orderId, HttpSession session){
        Integer userId = (Integer)session.getAttribute("userAccountId");
        Order order = orderService.selectOrderById(userId, orderId);
        //System.out.println(order.getOrderCreateTime());
//        try {
//            System.out.println(new ObjectMapper().writeValueAsString(order));
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//        }
        List<Orderitem> orderitems = orderService.selectItemByOrderId(orderId);
        List<Integer> serviceIds = orderitems.stream().map(Orderitem::getServId).collect(Collectors.toList());

        List<Service> services = serviceService.selectServiceOfAllByIds(serviceIds);    //获取商品信息
        List<Picture> pictures = pictureService.selectDefaultPicture(serviceIds);       //获取商品默认图片
        return Message.success().add("order", order).add("orderitems", orderitems).add("services", services).add("pictures",pictures);
    }
}
