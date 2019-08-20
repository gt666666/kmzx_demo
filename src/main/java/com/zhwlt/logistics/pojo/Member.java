package com.zhwlt.logistics.pojo;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;



@Setter
@Getter
@ToString
public class Member  {

    private String  ids;
    private String  name;
    private  Integer  companySalary;
    private  Boolean   IsDelete;
}

