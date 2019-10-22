package com.zhwlt.logistics.pojo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * 类描述：
 * 创建作者：gt
 * 创建日期 ： 2019/9/5
 */
@Data
@Component
public class CarInfo implements Serializable {
    private String  id;
    private String  carNumber;
    private  String  equipment;
    private  Long    newTime;
    private  String   loc;



}
