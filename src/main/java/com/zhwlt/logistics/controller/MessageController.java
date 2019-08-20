package com.zhwlt.logistics.controller;

import com.zhwlt.logistics.controller.abs.AbstractBaseController;
import com.zhwlt.logistics.service.IMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class MessageController extends AbstractBaseController {
        @Autowired
        private IMessageService messageService;

    public   String message(String key,String... mid){
        System.out.println(super.getMessage(key,mid));
          return super.getMessage("member.add.page");
    }
    public   String info(String msg){
        return this.messageService.index(msg);
    }
//    @RequestMapping(value = "/show",method = RequestMethod.GET)
    @GetMapping(value = "/show")
    public String show (String mid, Model  model){

//        ModelAndView mv = new ModelAndView();
//         mv.addObject("mid",mid);
//         mv.addObject("url","baidu.com");
//         mv.setViewName("message_show");
//        return mv;
        model.addAttribute("url","www.baidus.com");//request属性传递包装
        model.addAttribute("mid",mid);  //request属性传递包装
        System.out.println("*****************************");

        return "message_show";//此处只返回一个路径，该路径没有设置后缀，后缀默认是*.html
    }

}
