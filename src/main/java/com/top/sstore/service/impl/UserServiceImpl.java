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
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Transactional
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
    /*发送激活邮件*/
    @Autowired
    private IMailService mailService;

    /**
     * @author zh
     * @date 2019/6/2/002 18:17
     *  用户注册
     */
    @Override
    public boolean userRegistration(User user) {
        /*账号重复校验*/
        UserExample example = new UserExample();
        //查找用户名、邮箱是否重复：邮箱、用户名唯一性
        example.createCriteria().andUserNameEqualTo(user.getUserName());
        example.or().andUserEmailEqualTo(user.getUserEmail());      //  ||

//        example.or().andUserNameEqualTo(user.getUserName()).andUserEmailEqualTo(user.getUserEmail()));    // &&
//            example.or().andUserEmailEqualTo(user.getUserEmail());
//            example.or().andUserPhoneEqualTo(user.getUserPhone());
        long count = userMapper.countByExample(example);
        if(count == 0){ //账号不重复
            //添加状态位：未激活态
            user.setUserStatus(staticValues.getUserInactive());
            //添加激活码
            String userCdk = UUIDUtils.getUUID()+UUIDUtils.getUUID();
            user.setUserCdk(userCdk);
            //时间戳
            user.setCreateTime(new Date());
            int s = userMapper.insertSelective(user);
            if (s == 1){    //确定注册完成，发送验证码
                //发送邮件，包含CDK
                //url
//                    String url = "http://"+staticValues.getTomcatIP()+"/account/activate?userName="+user.getUserName()+"&userCdk="+userCdk;
//                    mailService.sendHtmlMail(user.getUserEmail(),"最后一步：激活账号", "<a href="+url+">点击我完成注册，网上商城</a>");
                boolean b =userService.sendEmail(user);
                if (b){
                    logger.info("send email unsuccess");
                    return true;
                } else {
                    logger.error("邮件发送失败");
                    throw new RuntimeException();   //邮件发送失败，抛异常
                }
            }else {
                logger.warn(user.getUserName()+"注册失败");
                return false;
            }
        }else{
            logger.warn("用户已存在");
            return false;
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
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(user.getUserName()).andUserPasswordEqualTo(user.getUserPassword());
        List<User> users = userMapper.selectByExample(example);
        if (users.size() == 1) {    //使用用户名、密码登录
            User user1 = users.get(0);
            if(userService.checkStatus(user1)) {  //检查用户账号是否激活
                logger.info(user1.getUserName() +"登录成功！");
                return user1;
            }else{
                logger.warn("账号未激活！");
            }
        } else {
            /*使用邮箱登录*/
            UserExample example1 = new UserExample();
            example1.createCriteria().andUserEmailEqualTo(user.getUserName()).andUserPasswordEqualTo(user.getUserPassword());
            List<User> users1 = userMapper.selectByExample(example1);
            if (users1.size() == 1) {    //用户信息正确
                User user1 = users1.get(0);
                if(userService.checkStatus(user1)) {  //检查用户账号是否激活
                    logger.info(user1.getUserName() + ":登录成功！");
                    return user1;
                }else{
                    logger.warn("账号未激活！");
                }
            } else {
                logger.warn("邮箱或密码错误！！");
            }
        }
        return null;//登录失败
    }

    /**
     * @author zh
     * @date 2019/6/14/014 15:13
     * 校验用户ID是否存在，存在返回true
     */
    @Override
    public boolean checkUserId(Integer userId) {
        UserExample example = new UserExample();
        example.createCriteria().andUserIdEqualTo(userId);
        long count = userMapper.countByExample(example);
        if (count == 1)
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
    public User showUserById(Integer userId) {
        UserExample example = new UserExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<User> users = userMapper.selectByExample(example);
        if (users.size() == 1)
            return users.get(0);
        else
            return null;
    }

    @Override
    public void updateUsername() {

    }

    @Override
    public boolean updatePassword(Integer userId, String oldPassword, String newPassword) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andUserIdEqualTo(userId).andUserPasswordEqualTo(oldPassword);
        long a = userMapper.countByExample(userExample);
        if (a == 1) {
            User user = new User();
            user.setUserId(userId);
            user.setUserPassword(newPassword);
            int i = userMapper.updateByPrimaryKeySelective(user);
            if (i == 1)
                return true;
        }
        return false;
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

    @Override
    public boolean checkUsername(String username) {
        UserExample example = new UserExample();
        example.createCriteria().andUserNameEqualTo(username);
        long l = userMapper.countByExample(example);
        if (l == 1)
            return true;
        else
            return false;
    }

    @Override
    public boolean checkEmail(String email) {
        UserExample example = new UserExample();
        example.createCriteria().andUserEmailEqualTo(email);
        long l = userMapper.countByExample(example);
        if (l == 1)
            return true;
        else
            return false;
    }
}
