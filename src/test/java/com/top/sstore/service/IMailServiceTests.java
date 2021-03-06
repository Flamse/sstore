package com.top.sstore.service;

import com.top.sstore.service.IMailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class IMailServiceTests {

    /**
     * 注入发送邮件的接口
     */
    @Autowired
    private IMailService mailService;

    /**
     * 测试发送文本邮件
     */
    @Test
    public void sendSimpleMail() {
        mailService.sendSimpleMail("1048605630@qq.com","神兽保佑无BUG","看我");
    }

    @Test
    public void sendHtmlMail() {
        mailService.sendHtmlMail("1@qq.com","神兽保佑无BUG","<a href='http://www.baidu.com'>check me</a>");
    }
}