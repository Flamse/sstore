package com.top.sstore.service.impl;

import com.top.sstore.dao.UserMapper;
import com.top.sstore.pojo.User;
import com.top.sstore.pojo.UserExample;
import com.top.sstore.service.IUserService;
import com.top.sstore.service.IMailService;
import com.top.sstore.utils.StaticValues;
import com.top.sstore.utils.UUIDUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImp implements IUserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StaticValues staticValues;

    /**
     * @author zh
     * @date 2019/6/4/004 9:21
     * 发送激活邮件
     */
    @Autowired
    private IMailService mailService;

    /**
     * @author zh
     * @date 2019/6/2/002 18:17
     *  用户注册
     */
    @Override
    public void userRegistration(User user) {
        /*非空校验，用户名、密码、Email不能为空*/
        if(user.getUserName() != null && user.getUserPassword() != null && user.getUserEmail() != null ){
            /*账号重复校验*/
            UserExample example = new UserExample();
            //查找用户名、邮箱和手机号是否重复：邮箱、用户名唯一性
            example.or().andUserNameEqualTo(user.getUserName());    //
            example.or().andUserEmailEqualTo(user.getUserEmail());  //
//            example.or().andUserPhoneEqualTo(user.getUserPhone());
            long count = userMapper.countByExample(example);
            if(count == 0){ //账号不重复
                //添加状态位：未激活态
                user.setUserStatus(staticValues.getUserInactive());
                //添加激活码
                String userCdk = UUIDUtils.getUUID()+UUIDUtils.getUUID();
                user.setUserCdk(userCdk);
                //
                user.setCreateTime(new Date());
                //新增用户,有重复插入的可能
                int s = userMapper.insertSelective(user);
                if (s == 1){    //确定注册完成，再发送验证码
                    //发送邮件，包含CDK
                    //url
                    String url = "http://"+staticValues.getTomcatIP()+"/account/activate?userName="+user.getUserName()+"&userCdk="+userCdk;
                    mailService.sendHtmlMail(user.getUserEmail(),"最后一步：激活账号", "<a href="+url+">点击我完成注册，网上商城</a>");
                    logger.info("sended email");
                }else {
                    logger.info("send email unsuccess!!");
                }
            }else{
                logger.info("用户已存在！！！");
            }
        }else {
            logger.info("用户信息不全");
        }
    }

    /**
     * @author zh
     * @date 2019/6/4/004 14:07
     * 用户登录,允许用户使用 用户名或邮箱 作为账号进行登录
     */
    @Override
    public User userLogin(User user) {
        /*非空校验*/
        if ((user.getUserName() != null || user.getUserEmail() != null) && user.getUserPassword() != null){
            if(user.getUserName() != null && user.getUserEmail() == null) { //使用用户名登录
                UserExample example = new UserExample();
                example.createCriteria().andUserNameEqualTo(user.getUserName());
                example.createCriteria().andUserPasswordEqualTo(user.getUserPassword());
                List<User> users = userMapper.selectByExample(example);
                if (users.size() == 1) {
                    logger.info("登录成功！");
                    return users.get(0);    //貌似存在问题
                } else {
                    logger.info("用户名或密码错误！！");
                }
            }else if(user.getUserName() == null && user.getUserEmail() != null){    //使用邮箱登录
                UserExample example = new UserExample();
                example.createCriteria().andUserEmailEqualTo(user.getUserEmail());
                example.createCriteria().andUserPasswordEqualTo(user.getUserPassword());
                List<User> users = userMapper.selectByExample(example);
                if (users.size() == 1) {
                    logger.info("登录成功！");
                    return users.get(0);    //貌似存在问题
                } else {
                    logger.info("用户名或密码错误！！");
                }
            }else {
                logger.info("！！！！！！！！！系统错误！！！！！！！！！！！"); //用户名和邮箱同时存在
            }
        }else {
            logger.info("用户名或密码不能为空！！");
        }
        return null;//登录失败
    }

    @Override
    public void checkUsername() {

    }

    @Override
    public void checkEmail() {

    }

    @Override
    public void checkPhone() {

    }

    @Override
    public String checkState() {
        return null;
    }

    @Override
    public User showUser() {

        return null;
    }

    @Override
    public void updateUsername() {

    }

    /**
     * @author zh
     * @date 2019/6/4/004 14:27
     * 账户激活
     */
    @Override
    public User updateStatus(User user) {
        UserExample example = new UserExample();
        if (user.getUserName() != null && user.getUserCdk() != null){
            //and查询
            example.createCriteria().andUserNameEqualTo(user.getUserName());
            example.createCriteria().andUserCdkEqualTo(user.getUserCdk());
            long count = userMapper.countByExample(example);

            if(count == 1){ //存在用户名为***，CDK为***的用户
                User user1 = new User();
                user1.setUserName(user.getUserName());
                user1.setUserStatus(staticValues.getUserActive());  //改变为激活态
                user1.setUserCdk("");   //激活成功后清空CDK    //建议用事务

                userMapper.updateByExampleSelective(user1,example); //  激活

                /*返回激活的用户*/
                UserExample example1 = new UserExample();
                example1.createCriteria().andUserNameEqualTo(user1.getUserName());
                List<User> users = userMapper.selectByExample(example1);
                return users.get(0);

            }else {
                logger.info("链接失效！！！");
            }
        }else{
            logger.info("无效连接！！！");
        }
        return null;
    }

    @Override
    public void plusAddress() {

    }

    @Override
    public void updateAddress() {

    }

    @Override
    public void showAddress() {

    }
}
