package com.top.sstore.service;

import com.top.sstore.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface IUserService {

    /**
     * @Author zh
     * @Description 注册用户（未激活）
     * @Return 返回主键
     * @Date 2019/5/29/029 11:16
     */
    public void userRegistration(User user);

    /**
     * @Author zh
     * @Description 用户登录
     * @Return 返回影响行的数目
     * @Date 2019/5/29/029 11:17
     */
    public User userLogin(User user);

    //用户登录注册需要的检查
    public void checkUsername();

    public void checkEmail();

    public void checkPhone();
    /**
     * @Author zh
     * @Description 
     * @Return 
     * @Date 2019/5/29/029 12:25
     */
    public String checkState();
    
    /**
     * @Author zh
     * @Description 展示用户个人信息
     * @Return 
     * @Date 2019/5/29/029 11:19
     */
    public User showUser();
    
    /**
     * @Author zh
     * @Description 修改用户名
     * @Return 
     * @Date 2019/5/29/029 11:19
     */
    public void updateUsername();

    /**
     * @Author zh
     * @Description 切换用户状态，激活与否。。。
     * @Return 
     * @Date 2019/5/29/029 11:19
     */
    public User updateStatus(User user);

    /**
     * @Author zh
     * @Description 增加地址
     * @Return 
     * @Date 2019/5/29/029 11:19
     */
    public void plusAddress();

    /**
     * @Author zh
     * @Description 修改地址
     * @Return 
     * @Date 2019/5/29/029 11:19
     */
    public void updateAddress();

    /**
     * @Author zh
     * @Description 展示地址
     * @Return 
     * @Date 2019/5/29/029 11:19
     */
    public void showAddress();


}
