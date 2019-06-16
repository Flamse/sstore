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
public class UserServiceImpl implements IUserService {
    /*日志*/
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private IUserService userService;
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
        /*账号重复校验*/
        UserExample example = new UserExample();
        //查找用户名、邮箱和手机号是否重复：邮箱、用户名唯一性
        example.or().andUserNameEqualTo(user.getUserName()).andUserEmailEqualTo(user.getUserEmail());
//            example.or().andUserEmailEqualTo(user.getUserEmail());
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
//                    String url = "http://"+staticValues.getTomcatIP()+"/account/activate?userName="+user.getUserName()+"&userCdk="+userCdk;
//                    mailService.sendHtmlMail(user.getUserEmail(),"最后一步：激活账号", "<a href="+url+">点击我完成注册，网上商城</a>");
                userService.sendEmail(user);
                logger.info("sended email");
            }else {
                logger.info("send email unsuccess");
            }
        }else{
            logger.warn("用户已存在");
        }
    }

    /**
     * @author zh
     * @date 2019/6/6/006 8:22
     * 发送激活邮件，需要用户名或邮箱、CDK激活码,不需要密码
     */
    @Override
    public boolean sendEmail(User user){
        //简化服务，只单纯发送邮件
        if ( user != null){
            if (user.getUserCdk() != null){  //激活码存在，才能发
                if (user.getUserName() != null){    //发送基于用户名的激活邮件
                    String url = "http://"+staticValues.getTomcatIP()+"/account/activate?userName="+user.getUserName()+"&userCdk="+user.getUserCdk();
                    logger.info("用户开始主动激活。");
                    mailService.sendHtmlMail(user.getUserEmail(),"最后一步：激活账号", "<a href="+url+">点击我完成注册，网上商城</a>");
                    logger.info("邮件已发送！");
                    return true;
                }
            }else if (user.getUserEmail() != null){
                String url = "http://"+staticValues.getTomcatIP()+"/account/activate?userName="+user.getUserEmail()+"&userCdk="+user.getUserCdk();
                logger.info("用户开始主动激活。");
                mailService.sendHtmlMail(user.getUserEmail(),"最后一步：激活账号", "<a href="+url+">点击我完成注册，网上商城</a>");
                logger.info("邮件已发送！");
                return true;
            }else {
                logger.info("用户信息不全，无法发送！！");
            }
        }
        return false;
    }

    /**
     * @author zh
     * @date 2019/6/4/004 14:07
     * 用户登录,允许用户使用 用户名或邮箱 作为账号进行登录
     */
    @Override
    public User userLogin(User user) {
        User user2 = userService.showUser(user);
        if(user.getUserName().equals(user2.getUserName())) { //使用用户名、密码登录
//                System.out.println(user.getUserName()+user.getUserPassword());
            UserExample example = new UserExample();
            example.createCriteria().andUserNameEqualTo(user.getUserName()).andUserPasswordEqualTo(user.getUserPassword());
//                example.createCriteria().andUserPasswordEqualTo(user.getUserPassword());
            List<User> users = userMapper.selectByExample(example);
//                System.out.println(users.get(0).getUserName());
            if (users.size() == 1) {    //用户信息正确
                User user1 = users.get(0);
                if(userService.checkStatus(user1)) {  //检查用户账号是否激活
                    logger.info(user1.getUserName() +"登录成功！");
                    return user1;
                }else{
                    logger.warn("账号未激活！");
                }
            } else {
                logger.info("用户名或密码错误！！");
            }
        }else if(user.getUserName().equals(user2.getUserEmail())){    //使用邮箱登录
            UserExample example = new UserExample();
            example.createCriteria().andUserEmailEqualTo(user.getUserEmail()).andUserPasswordEqualTo(user.getUserPassword());
            List<User> users = userMapper.selectByExample(example);
            if (users.size() == 1) {    //用户信息正确
                User user1 = users.get(0);
                if(userService.checkStatus(user1)) {  //检查用户账号是否激活
                    logger.info(user1.getUserName() + ":登录成功！");
                    return user1;
                }else{
                    logger.warn("账号未激活！");
                }
            } else {
                logger.warn("邮箱或密码错误！！");
            }
        }else {
            logger.error("！！！！！！！！系统错误！！！！！！！！！"); //用户名和邮箱同时存在
        }
        return null;//登录失败
    }

    /**
     * @author zh
     * @date 2019/6/14/014 15:13
     * 判断字段 是否存在; 不存在返回true
     */
    @Override
    public boolean checkIfBeing(String string) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(string);
        long count = userMapper.countByExample(example);
        if (count == 0)
            return true;
        return false;
    }


    /**
     * @author zh
     * @date 2019/6/5/005 15:29
     * 查看用户状态
     */
    @Override
    public boolean checkStatus(User user) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(user.getUserName());
        List<User> users = userMapper.selectByExample(example);
        if (users.size() == 1){
            if (users.get(0).getUserStatus().equals(staticValues.getUserActive())){
                return true;
            } else {
                return false;
            }

        }else {
            UserExample example1 = new UserExample();
            example1.createCriteria().andUserEmailEqualTo(user.getUserName());
            List<User> users1 = userMapper.selectByExample(example1);
            if (users1.get(0).getUserStatus().equals(staticValues.getUserActive())) {
                return true;
            } else {
                return false;
            }
        }
    }

    @Override
    public User showUser(User user) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(user.getUserName());
        List<User> users = userMapper.selectByExample(example);
       return users.get(0);
    }

    @Override
    public void updateUsername() {

    }

    /**
     * @author zh
     * @date 2019/6/4/004 14:27
     * 账户激活，使用用户名或邮箱,CDK
     */
    @Override
    public boolean updateStatus(User user) {
        UserExample example = new UserExample();
        if (user.getUserName() != null && user.getUserCdk() != null){   //基于用户名激活
            //and查询
            example.createCriteria().andUserNameEqualTo(user.getUserName()).andUserCdkEqualTo(user.getUserCdk());
            long count = userMapper.countByExample(example);

            if(count == 1){ //存在用户名为***，CDK为***的用户
                User user1 = new User();
                user1.setUserName(user.getUserName());
                user1.setUserStatus(staticValues.getUserActive());  //改变为激活态
                user1.setUserCdk("");   //激活成功后清空CDK    //建议用事务

                int a = userMapper.updateByExampleSelective(user1,example); //  激活
                if (a == 1){
                    return true;
                }
            }else {
                logger.warn("链接失效！！！");
            }
        }else if (user.getUserEmail() != null && user.getUserCdk() != null) {   //基于邮箱激活
            //and查询
            example.createCriteria().andUserNameEqualTo(user.getUserEmail()).andUserCdkEqualTo(user.getUserCdk());
            long count = userMapper.countByExample(example);

            if (count == 1) { //存在邮箱为***，CDK为***的用户
                User user1 = new User();
                user1.setUserEmail(user.getUserEmail());
                user1.setUserStatus(staticValues.getUserActive());  //改变为激活态
                user1.setUserCdk("");   //激活成功后清空CDK    //建议用事务

                int a = userMapper.updateByExampleSelective(user1, example); //  激活
                if (a == 1) {
                    return true;
                }
            } else {
                logger.warn("无效连接！！！");
            }
        }else {
            logger.error("系统错误！！");
        }
        return false;
    }

    @Override
    public void plusAddress(User user) {
    }

    @Override
    public void updateAddress() {

    }

    @Override
    public void showAddress() {

    }
}
