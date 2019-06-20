package com.zr.demo.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zr.demo.dao.UserDao;
import com.zr.demo.model.User;
import com.zr.demo.service.UserService;

import producer.IMessageProducerService;

@RestController
public class MainController {
	
	@Autowired  
    private UserService  userService;
	
	@Autowired
    private IMessageProducerService messageProducer;
	
	@Resource
    private JavaMailSender javaMailSender ;
	
	@Resource
    private RedisTemplate<String, String> redisTemplate;
	
    @RequestMapping(value="/redis")
    public void testSet() {
        this.redisTemplate.opsForValue().set("study", "java");
        System.out.println(this.redisTemplate.opsForValue().get("study"));
    }
	
    @RequestMapping(value="/mail")
    public void testSendMail() {
        SimpleMailMessage message = new SimpleMailMessage() ;    // 要发送的消息内容
        message.setFrom("你自己的邮箱地址，1499296575@qq.com");
        message.setTo("接收者的邮箱地址，2248342419@qq.com");
        message.setSubject("测试邮件）");
        message.setText("好好学习，天天向上");
       javaMailSender.send(message);
    }
	
    @RequestMapping(value="/send")
    public void testSend() throws Exception {
        for (int x = 0; x < 10; x++) {
            this.messageProducer.sendMessage("study - " + x);
        }
    }
	
	@RequestMapping(value = "/abc", method = RequestMethod.GET)
	public User home() {
		return userService.selectUserById(1);
	}

}
