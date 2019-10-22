package com.zhwlt.logistics.pojo;

import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.*;

/**
 * 类描述：
 * 创建作者：gt
 * 创建日期 ： 2019/9/2
 */
@Data
@Component
public class Dept implements Serializable {
    private int deptno;
    private String dname;
    private String loc;
    private Date time;


}
