package com.top.sstore.utils;

import org.springframework.beans.factory.annotation.Value;

public class StaticValues {
    @Value("${ipAddress.tomcat}")
    private static String tomcatIP;

    //状态码
    @Value("${status.user.inactive}")
    private static Integer userInactive;

    @Value("${status.user.active}")
    private static Integer userActive;

    @Value("${status.service.instock}")
    private static Integer serviceInstock;

    @Value("${status.service.outstock}")
    private static Integer serviceOutstock;

    @Value("${status.order.pushOrder}")
    private static Integer orderPushOrder;

    @Value("${status.order.payOrder}")
    private static Integer orderPayOrder;

    @Value("${status.order.distributeOrder}")
    private static Integer orderDistributeOrder;

    @Value("${status.order.completeOrder}")
    private static Integer ordercCompleteOrder;

    @Value("${status.order.cancelOrder}")
    private static Integer orderCancelOrder;


    public static String getTomcatIP() {
        return tomcatIP;
    }

    public static Integer getUserInactive() {
        return userInactive;
    }

    public static Integer getUserActive() {
        return userActive;
    }

    public static Integer getServiceInstock() {
        return serviceInstock;
    }

    public static Integer getServiceOutstock() {
        return serviceOutstock;
    }

    public static Integer getOrderPushOrder() {
        return orderPushOrder;
    }

    public static Integer getOrderPayOrder() {
        return orderPayOrder;
    }

    public static Integer getOrderDistributeOrder() {
        return orderDistributeOrder;
    }

    public static Integer getOrdercCompleteOrder() {
        return ordercCompleteOrder;
    }

    public static Integer getOrderCancelOrder() {
        return orderCancelOrder;
    }
}
