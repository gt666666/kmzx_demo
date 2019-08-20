package com.zhwlt.logistics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;

import java.util.concurrent.Executors;

@Configuration  //定时调度的配置类一定要实现指定的父接口
public class SchedulerConfig  implements SchedulingConfigurer {
    @Override

    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        taskRegistrar.setScheduler(Executors.newScheduledThreadPool(100)); //开启一个线程调度池,开辟线程池的大小为100

    }
}
