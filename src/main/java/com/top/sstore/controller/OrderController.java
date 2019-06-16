package com.top.sstore.controller;

import com.top.sstore.pojo.Order;
import com.top.sstore.pojo.Orderitem;
import com.top.sstore.service.IOrderService;
import com.top.sstore.utils.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @GetMapping("/push")
    public Message push(Integer addressId, List<Integer> serviceIds, HttpSession session){
        Integer userId = (Integer) session.getAttribute("userAccountId");
        boolean b = orderService.pushOrder(addressId, userId, serviceIds);
        if (b){
            return Message.success();
        }
        return Message.fail();
    }

    @GetMapping("/pay")
    public Message pay(Integer orderId, HttpSession session){
        Integer userId = (Integer)session.getAttribute("userAccountId");
        boolean b = orderService.payOrder(orderId, userId);
        if (b){
            return Message.success();
        }
        return Message.fail();
    }

    @GetMapping("/distribute")
    public Message distribute(Integer orderId, HttpSession session){
        Integer userId = (Integer)session.getAttribute("userAccountId");
        boolean b = orderService.distributeOrder(orderId, userId);
        if (b){
            return Message.success();
        }
        return Message.fail();
    }

    @GetMapping("/complete")
    public Message complete(Integer orderId, HttpSession session){
        Integer userId = (Integer)session.getAttribute("userAccountId");
        boolean b = orderService.completeOrder(orderId, userId);
        if (b){
            return Message.success();
        }
        return Message.fail();
    }

    @GetMapping("/cancel")
    public Message cancel(Integer orderId, HttpSession session){
        Integer userId = (Integer)session.getAttribute("userAccountId");
        boolean b = orderService.cancelOrder(orderId, userId);
        if (b){
            return Message.success();
        }
        return Message.fail();
    }

    @GetMapping("/show")
    public Message show(HttpSession session){
        Integer userId = (Integer)session.getAttribute("userAccountId");
        List<Order> orders = orderService.selectOrderOfAll(userId);
        return Message.success().add("orders", orders);
    }

    @GetMapping("/showOrder")
    public Message showOne(Integer orderId, HttpSession session){
        Integer userId = (Integer)session.getAttribute("userAccountId");
        Order order = orderService.selectOrderById(userId, orderId);
        List<Orderitem> orderitems = orderService.selectItemByOrderId(orderId);
        return Message.success().add("order", order).add("orderitems", orderitems);
    }


}
