package com.zhwlt.logistics.controller.abs;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.cglib.core.Local;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class AbstractBaseController {
    @Autowired
    private MessageSource messageSource;   //自动注入此资源对象

    public String getMessage(String key, String... args) {

        return this.messageSource.getMessage(key, args, Locale.getDefault());
    }

    // 从字面意思可以看出这个的作用是给Binder做初始化的，被此注解的方法可以对WebDataBinder初始化。
// webDataBinder是用于表单到方法的数据绑定的！
// @InitBinder只在@Controller中注解方法来为这个控制器注册一个绑定器初始化方法，方法只对本控制器有效。   
    @InitBinder
    public void initBinder(WebDataBinder binder) {    // 在本程序里面需要针对于日期格式进行处理
        // 首先建立一个可以将字符串转换为日期的工具程序类
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        // 明确的描述此时需要注册一个日期格式的转化处理程序类
        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));
    }
}
