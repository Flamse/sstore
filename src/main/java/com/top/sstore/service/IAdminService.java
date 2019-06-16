package com.top.sstore.service;

import com.top.sstore.pojo.Administrator;

public interface IAdminService {

    /**
     * @author zh
     * @date 2019/6/6/006 23:15
     * 管理员登录
     */
    boolean signIn(Administrator administrator);

}
