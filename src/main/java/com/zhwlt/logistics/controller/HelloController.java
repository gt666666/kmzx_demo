package com.zhwlt.logistics.controller;


import com.zhwlt.logistics.service.IMemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


//复合注解：@RestController=@Controller+@ResponseBody+其它
@RestController
public class HelloController {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private IMemberService memberService;
    private Logger log = LoggerFactory.getLogger(HelloController.class);

    @RequestMapping("/")
        //表示访问路径的映射
        // @ResponseBody:在Restful架构之中，该注解表示直接将返回的数据以字符串或JSON的形式获得
    String home() {
        //this.memberService.findAll();
        log.info("********12345");
        return "www.baidu.com11234567778";
    }

    @RequestMapping("/echo")
    String echo(String str) {
        return str;
    }


    @RequestMapping(value = "/message/{msg}", method = RequestMethod.GET)
    String msg(@PathVariable("msg") String msg) {
        return msg;
    }

    @RequestMapping("/object")
    public String object(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("客户端IP地址：" + request.getRemoteAddr());
        System.out.println("获取客户端响应编码：" + response.getCharacterEncoding());
        System.out.println("取得SessionID：" + request.getSession().getId());
        System.out.println("取得真实路径：" + request.getServletContext().getRealPath("/upload"));
        return "www.baidu.com";
    }
}
