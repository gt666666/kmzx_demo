package com.zhwlt.logistics.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

@Mapper
@Component
public interface IOtherexpensesDAO {
    public void  findAll();
}
