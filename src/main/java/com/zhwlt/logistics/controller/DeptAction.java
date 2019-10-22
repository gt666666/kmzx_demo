package com.zhwlt.logistics.controller;

import com.alibaba.fastjson.JSONObject;
import com.zhwlt.logistics.pojo.Dept;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController // 以Rest风格进行数据的返回
public class DeptAction {
    @GetMapping("/cors/dept_list")
    public Object list(String dname,String loc) {
        System.out.println(dname+"********"+loc);
        List<Dept> allDepts = new ArrayList<>() ;
        for (int x = 0 ; x < 10 ; x ++) {
            Dept dept = new Dept() ;
            dept.setDeptno(x );
            dept.setDname(dname + " - " + x);
            dept.setLoc(loc + " - " + x);
            allDepts.add(dept) ; // 添加集合
        }
        System.out.println(allDepts);
        return allDepts ;
    }
    @PostMapping("/cors/dept_add")
    public Object add(Dept dept, MultipartFile photo) {
        Map<String,Object> map = new HashMap<>() ;
        dept.setDeptno(99); // 假设这个数据是由ORM组件得到的
        System.out.println(dept.getDname());
        map.put("dept",dept) ;
        if (photo != null) {    // 有上传文件
            System.err.println("【文件名称】" + photo.getOriginalFilename());
            System.err.println("【文件大小】" + photo.getSize());
            System.err.println("【文件类型】" + photo.getContentType());
            map.put("file",photo.getOriginalFilename()) ;
            map.put("size",photo.getSize()) ;
            map.put("contentType",photo.getContentType()) ;
        }
        return map ;
    }
}
