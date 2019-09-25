package com.top.sstore.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class StaticValues {
    @Value("${ipAddress.tomcat}")
    private String tomcatIP;

    //分页控制
    @Value("${pageSizeBySort}")
    private Integer pageSizeBySort;
    @Value("${pageSizeByCart}")
    private Integer pageSizeByCart;
    @Value("${pageSizeBySearch}")
    private Integer pageSizeBySearch;
    @Value("${pageSizeByRecommend}")
    private Integer pageSizeByRecommend;

    //状态码
    @Value("${status.user.inactive}")
    private Integer userInactive;
    @Value("${status.user.active}")
    private Integer userActive;

    @Value("${status.service.instock}")
    private Integer serviceInstock;
    @Value("${status.service.outstock}")
    private Integer serviceOutstock;

    @Value("${status.order.pushOrder}")
    private Integer orderPushOrder;
    @Value("${status.order.payOrder}")
    private Integer orderPayOrder;
    @Value("${status.order.distributeOrder}")
    private Integer orderDistributeOrder;
    @Value("${status.order.completeOrder}")
    private Integer orderCompleteOrder;
    @Value("${status.order.cancelOrder}")
    private Integer orderCancelOrder;

    //用户session key
    @Value("${session.userId}")
    private String sessionUserId;





    public String getSessionUserId() {
        return sessionUserId;
    }

    public Integer getPageSizeBySearch() {
        return pageSizeBySearch;
    }

    public Integer getPageSizeByRecommend() {
        return pageSizeByRecommend;
    }

    public Integer getPageSizeBySort() {
        return pageSizeBySort;
    }

    public Integer getPageSizeByCart() {
        return pageSizeByCart;
    }


    public String getTomcatIP() {
        return tomcatIP;
    }

    public Integer getUserInactive() {
        return userInactive;
    }

    public Integer getUserActive() {
        return userActive;
    }

    public Integer getServiceInstock() {
        return serviceInstock;
    }

    public Integer getServiceOutstock() {
        return serviceOutstock;
    }

    public Integer getOrderPushOrder() {
        return orderPushOrder;
    }

    public Integer getOrderPayOrder() {
        return orderPayOrder;
    }

    public Integer getOrderDistributeOrder() {
        return orderDistributeOrder;
    }

    public Integer getOrderCompleteOrder() {
        return orderCompleteOrder;
    }

    public Integer getOrderCancelOrder() {
        return orderCancelOrder;
    }
}
