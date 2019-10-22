package com.zhwlt.logistics.config;

import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class AxiosInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("token") ; // 随头信息发送token
        System.err.println("【AxiosInterceptor.preHandle()】接收客户端发送的Token头信息：" + token);
        if (token == null) {    // 没有指定的token
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // 设置状态码
            response.getWriter().println(String.format("{'code':%s,'message':'%s'}", HttpServletResponse.SC_UNAUTHORIZED, "Invlidate Request Token"));
            return false ;
        }
        return true;
    }
}
