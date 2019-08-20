package com.zhwlt.logistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

//@EnableAutoConfiguration  开启自动化配置，会自动进行Spring和Spring MVC的配置
//@ComponentScan("com.zhwlt.com")
//@SpringBootApplication=@EnableAutoConfiguration+@ComponentScan("com.zhwlt.com")+其它配置
@SpringBootApplication //自带子包扫描
@EnableScheduling   //启动间隔调度
public class Application extends SpringBootServletInitializer {
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder applicationBuilder) {
        return applicationBuilder.sources(Application.class);
    }

    public static void main(String  args[]){
        SpringApplication.run(Application.class,args);
    }
}