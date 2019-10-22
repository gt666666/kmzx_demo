package com.zhwlt.logistics.config;
import com.zhwlt.logistics.util.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//@Configuration
public class MyWebApplicationConfig extends WebMvcConfigurationSupport {	// 定义MVC配置

	public void addInterceptors(InterceptorRegistry registry) {	// 进行拦截器的注册处理操作
		registry.addInterceptor(new MyInterceptor()).addPathPatterns("/**") ;	// 匹配路径
		super.addInterceptors(registry);
	}
}