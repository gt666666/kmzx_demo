package com.zhwlt.logistics.mapper;

import com.zhwlt.logistics.pojo.Student;

/**
 * 类描述：
 * 创建作者：gt
 * 创建日期 ： 2019/9/26
 */
public class Test extends TestDAO<Student> {
    @Override
    protected Class<Student> getEntityClass() {
        return   Student.class;
    }
}
