package com.zhwlt.logistics.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.resource.ClassPathResource;
import cn.hutool.core.util.URLUtil;
import cn.hutool.http.HttpUtil;

import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.zhwlt.logistics.pojo.Course;
import com.zhwlt.logistics.pojo.Member;
import com.zhwlt.logistics.pojo.Student;
import com.zhwlt.logistics.util.JxlsUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类描述：
 * 创建作者：gt
 * 创建日期 ： 2019/8/4
 */
@RestController
public class hutoolController {
    @GetMapping("/testStudent")
    public void  testStudent(HttpServletResponse response) throws Exception {
        List<Student> students = new ArrayList<>();
        Student student = new Student();
        student.setName("张三");
        student.setGender("男");
        student.setGradeClass("初一一班");
        List<Course> courses = new ArrayList<>();
        Course course = new Course();
        course.setCourseName("语文");
        course.setCourseScore("98");
        courses.add(course);
        course = new Course();
        course.setCourseName("数学");
        course.setCourseScore("105");
        courses.add(course);
        course = new Course();
        course.setCourseName("物理");
        course.setCourseScore("80");
        courses.add(course);
        student.setCourses(courses);
        students.add(student);

        student = new Student();
        student.setName("王丽丽");
        student.setGender("女");
        student.setGradeClass("初一二班");
        courses = new ArrayList<>();
        course = new Course();
        course.setCourseName("语文");
        course.setCourseScore("102");
        courses.add(course);
        course = new Course();
        course.setCourseName("数学");
        course.setCourseScore("110");
        courses.add(course);
        student.setCourses(courses);
        students.add(student);

        student = new Student();
        student.setName("李梅");
        student.setGender("女");
        student.setGradeClass("初一三班");
        courses = new ArrayList<>();
        course = new Course();
        course.setCourseName("语文");
        course.setCourseScore("110");
        courses.add(course);
        course = new Course();
        course.setCourseName("数学");
        course.setCourseScore("100");
        courses.add(course);
        course = new Course();
        course.setCourseName("物理");
        course.setCourseScore("85");
        courses.add(course);
        student.setCourses(courses);
        students.add(student);
        //模板里展示的数据
        Map<String, Object> data = new HashMap<>();
        data.put("students", students);
        // 模板输入流和输出流
        InputStream in = new ClassPathResource("doc/studentTemplate.xlsx").getStream();
        // 向response输出文件流，浏览器下载文件
        response.setContentType("application/x-download");
        response.setHeader("content-disposition", "attachment;filename=" + URLUtil.encode("回通运营车辆GPS监控平台监控管理回通台账.xls"));
        OutputStream out = response.getOutputStream();
        //调用封装的工具类，传入模板路径，输出流，和装有数据的Map,按照模板导出
        JxlsUtil.exportExcel(in, out, data);
        //推出流+关闭流
        out.flush();
        response.flushBuffer();
    }
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
