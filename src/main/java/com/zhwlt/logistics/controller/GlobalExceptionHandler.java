package com.zhwlt.logistics.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

public class GlobalExceptionHandler {
    public static  final   String DEFAULT_ERROR_VIEW="error";//定义错误显示页，error.html
    @ExceptionHandler(Exception.class)//所有的异常都是Exception子类
    public ModelAndView  defaultErrorHandler(HttpServletRequest   request,Exception e){
        ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW); // 设置跳转路径
	    mav.addObject("exception", e); // 将异常对象传递过去
		mav.addObject("url", request.getRequestURL()); // 获得请求的路径
		return mav;

    }
}
