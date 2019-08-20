package com.zhwlt.logistics;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;

@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class testEmail {
    @Resource
    private JavaMailSender  javaMailSender;
    @Test
    public void testSendEmail(){
               SimpleMailMessage   message=new SimpleMailMessage();//要发送的消息内容
               message.setFrom("979627462@qq.com");
               message.setTo("522420541@qq.com");
               message.setSubject("来自某某的");
               message.setText("你是个死猪猪");
               this.javaMailSender.send(message);
    }
}
