package com.zhwlt.logistics.service.impl;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;


@Service
public class MessageConsumerService {
   //@RabbitListener(queues = "com.zhwlt.queue")
    public void  receiveMessage(String text){//进行消息接收处理

        System.err.println("【***接收消息***】"+text);
    }
}
