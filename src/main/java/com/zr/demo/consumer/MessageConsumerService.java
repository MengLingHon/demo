package com.zr.demo.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class MessageConsumerService {
	
    @JmsListener(destination="study.msg.topic")
    public void receiveMessage(String text) {    // 进行消息接收处理
        System.err.println("【*** 接收消息 ***】" + text);
    }
    
    @JmsListener(destination="study.msg.topic")
    public void receiveMessage1(String text) {    // 进行消息接收处理
        System.err.println("【*** 接收消息 1***】" + text);
    }
}