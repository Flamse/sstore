package com.top.sstore.service;

import com.top.sstore.pojo.User;

public interface IUserService {

    /**
     * @Author zh
     * @Description 注册用户（未激活）
     * @Return 返回主键
     * @Date 2019/5/29/029 11:16
     */
    void userRegistration(User user);
    /**
     * @author zh
     * @date 2019/6/6/006 8:19
     * 发送激活邮件
     */
    boolean sendEmail(User user);

    /**
     * @Author zh
     * @Description 用户登录
     * @Return 返回影响行的数目
     * @Date 2019/5/29/029 11:17
     */
    User userLogin(User user);

    //用户登录注册需要的检查存在
    boolean checkIfBeing(String string);

    /**
     * @Author zh
     * @Description 
     * @Return 检查状态
     * @Date 2019/5/29/029 12:25
     */
    boolean checkStatus(User user);
    
    /**
     * @Author zh
     * @Description 展示用户个人信息
     * @Return 
     * @Date 2019/5/29/029 11:19
     */
    User showUser(User user);
    
    /**
     * @Author zh
     * @Description 修改用户名
     * @Return 
     * @Date 2019/5/29/029 11:19
     */
    void updateUsername();

    /**
     * @Author zh
     * @Description 切换用户状态，激活与否。。。
     * @Return 
     * @Date 2019/5/29/029 11:19
     */
    boolean updateStatus(User user);

    /**
     * @Author zh
     * @Description 增加地址
     * @Return 
     * @Date 2019/5/29/029 11:19
     */
    void plusAddress(User user);

    /**
     * @Author zh
     * @Description 修改地址
     * @Return 
     * @Date 2019/5/29/029 11:19
     */
    void updateAddress();

    /**
     * @Author zh
     * @Description 展示地址
     * @Return 
     * @Date 2019/5/29/029 11:19
     */
    void showAddress();


}
