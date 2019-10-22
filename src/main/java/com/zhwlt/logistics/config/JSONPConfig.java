package com.zhwlt.logistics.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.nio.charset.Charset;
import java.util.List;

//@Configuration
//@EnableWebMvc       // 启用MVC的环境配置
public class JSONPConfig {
    @Bean
    public WebMvcConfigurer getCorsConfig() {   //
        return new WebMvcConfigurer() { // 进行WEB的配置
            @Override
            public void configureMessageConverters(
                    List<HttpMessageConverter<?>> converters) { // 进行消息的转换
                StringHttpMessageConverter converter = new StringHttpMessageConverter(
                        Charset.forName("UTF-8")) ; // 所有的请求都以UTF-8编码为主
                converters.add(converter) ; // 追加一个转换器
            }
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/cors/**")         // 配置指定匹配路径
                        .allowedHeaders("*")        // 可以进行头部信息发送
                        .allowedOrigins("*")        // 接收任意的域名请求
                        .allowedMethods("POST,GET")        // 接收所有的请求模式
                        .allowCredentials(true)     // 允许进行Cookie的发送
                        .maxAge(3600) ;             // 请求的缓存时间
            }
        } ;
    }

}
