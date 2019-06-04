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

@Service
public class UserServiceImp implements IUserService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StaticValues staticValues;

//    @Autowired
//    private UserExample example;

    //发送邮件
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
                String userCDK = UUIDUtils.getUUID()+UUIDUtils.getUUID();
                user.setUserCdk(userCDK);
                //
                user.setCreateTime(new Date());
                //新增用户,有重复插入的可能
                int s = userMapper.insertSelective(user);
                if (s == 1){    //确定注册完成，再发送验证码
                    //发送邮件，包含CDK
                    //url
                    String url = "http://"+staticValues.getTomcatIP()+"/activate_account?username="+user.getUserName()+"&cdk="+userCDK;
                    mailService.sendSimpleMail(user.getUserEmail(),"最后一步：激活账号", "请点击激活码完成注册："+url);
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

    @Override
    public Integer userLogin() {
        return null;
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
    public void showUser() {

    }

    @Override
    public void updateUsername() {

    }

    @Override
    public void updateStatus(User user) {
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

//                userMapper.updateByPrimaryKeySelective(user1);
                userMapper.updateByExampleSelective(user1,example);

            }else {
                logger.info("激活失败！！！！用户ID或CDK错误");
            }
        }else{
            logger.info("连接失效！！！！！！！！！！！");
        }



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
