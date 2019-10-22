package com.zhwlt.logistics;

import com.zhwlt.logistics.pojo.Course;
import com.zhwlt.logistics.pojo.Student;
import com.zhwlt.logistics.util.JxlsUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestExcel {
    @Test
    public   void  Excel() throws Exception {
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
        // 模板路径和输出流
        String templatePath = "E:\\jxls\\studentTemplate.xls";
        OutputStream os = new FileOutputStream("E:\\jxls\\student.xls");
        //调用封装的工具类，传入模板路径，输出流，和装有数据的Map,按照模板导出
        JxlsUtil.exportExcel(templatePath, os, data);
    }
}
