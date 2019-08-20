package com.zhwlt.logistics.service.impl;

import com.zhwlt.logistics.service.IMessageService;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements IMessageService {
    @Override
    public String index(String msg) {
        System.out.println(msg);
        return msg;
    }
}
