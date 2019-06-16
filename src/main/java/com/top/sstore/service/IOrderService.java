package com.top.sstore.service;

import com.top.sstore.pojo.Order;
import com.top.sstore.pojo.Orderitem;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public interface IOrderService {

//    Map<Integer, BigDecimal> getTotals(Integer addressId, Integer userId, List<Integer> servId);

    /**
     * @author zh
     * @date 2019/6/6/006 21:54
     * 下单，操作两张表（order， orderitem）
     */
    boolean pushOrder(Integer addressId, Integer userId, List<Integer> servId);

    /**
     * @author zh
     * @date 2019/6/6/006 22:27
     * 付款
     */
    boolean payOrder(Integer orderId, Integer userId);

    /**
     * @author zh
     * @date 2019/6/6/006 22:27
     * 发货
     */
    boolean distributeOrder(Integer orderId, Integer userId);

    /**
     * @author zh
     * @date 2019/6/6/006 22:27
     * 签收
     */
    boolean completeOrder(Integer orderId, Integer userId);

    /**
     * @author zh
     * @date 2019/6/6/006 22:28
     * 取消订单
     */
    boolean cancelOrder(Integer orderId, Integer userId);

    /**
     * @author zh
     * @date 2019/6/6/006 22:59
     * 查看所有订单通过用户ID
     */
    List<Order> selectOrderOfAll(Integer userId);

    /**
     * @author zh
     * @date 2019/6/6/006 23:01
     * 查看订单信息通过 用户ID + 订单ID
     */
    Order selectOrderById(Integer userId, Integer orderId);

    /**
     * @author zh
     * @date 2019/6/6/006 23:07
     * 查看订单项 通过订单ID
     */
    List<Orderitem> selectItemByOrderId(Integer orderId);


}
