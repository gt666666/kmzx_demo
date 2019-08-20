package com.zhwlt.logistics.enums;

import lombok.Getter;
import lombok.ToString;

/**
 * 方法描述：只带数据对象的CommonResult
 * 创建作者：$(USER)
 * 创建日期 ： 2019/7/31
 */
@ToString
@Getter
public enum  ResultEnum {
    SUCCESS(1000,"成功");
    private  int code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
