package com.zhwlt.logistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller//表明是控制器类
@EnableAutoConfiguration  //开启自动配置处理
public class SampleController {
//    @RequestMapping("/")   //表示访问路径的映射
//    @ResponseBody  //在Restful架构之中，该注解表示直接将返回的数据以字符串或JSON的形式获得
//    String  home(){
//        return  "baidu.com";
//    }
//    public static void  main(String args[]){
//        SpringApplication.run(SampleController.class,args);
//    }
}
