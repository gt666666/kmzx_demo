package com.zhwlt.logistics.pojo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.msgpack.annotation.Message;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
public class Member  implements Serializable {
    private String  ids;
    private String  name;
    private Double  salary;
    private Integer  age;
    private  Integer  companySalary;
    private  Boolean   IsDelete;
}

