package com.top.sstore.common;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * @author zh
 * @date 2019/6/4/004 20:07
 * 页面渲染
 */
//@Component
public class CommonErrorPageRegistrar implements ErrorPageRegistrar {

    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        ErrorPage e404 = new ErrorPage(HttpStatus.NOT_FOUND,"/404.html");
        ErrorPage e500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/500.html");
        //单独渲染IllegalAccessException.class异常
        ErrorPage args = new ErrorPage(IllegalAccessException.class,"/args.html");
        registry.addErrorPages(e404,e500,args);
}
}
