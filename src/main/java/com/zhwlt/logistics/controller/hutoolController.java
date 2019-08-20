package com.zhwlt.logistics.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.http.HttpUtil;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.zhwlt.logistics.pojo.Member;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * 类描述：
 * 创建作者：gt
 * 创建日期 ： 2019/8/4
 */
@RestController
public class hutoolController {

    @GetMapping("/hutool")
    public void testHuttol(Member vo) {

        Map<String, Object> map = BeanUtil.beanToMap(vo);
        System.out.println("******" + map);
        // 输出为：{companySalary=null, name=高挺, ids=11

        JSONObject json1 = JSONUtil.createObj();
        json1.put("a", "value1");
        json1.put("b", "value2");
        json1.put("c", "value3");
        System.out.println(json1);
        // 输出为：{"a":"value1","b":"value2","c":"value3"}

        String jsonStr = "{\"b\":\"value2\",\"c\":\"value3\",\"a\":\"value1\"}";
        //方法一：使用工具类转换
        JSONObject jsonObject = JSONUtil.parseObj(jsonStr);
        //方法二：new的方式转换
        JSONObject jsonObject2 = new JSONObject(jsonStr);
        //JSON对象转字符串
        jsonObject.toString();
        System.out.println(jsonObject);
        //输出为：{"a":"value1","b":"value2","c":"value3"}

        //方法1
        JSONArray array = JSONUtil.createArray();
        //方法2
        // JSONArray array= new JSONArray();
        array.add("value1");
        array.add("value2");
        array.add("value3");
        //转为JSONArray字符串
        array.toString();
        //输出为:["value1","value2","value3"]
    }
}
