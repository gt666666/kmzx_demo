package com.zhwlt.logistics.service;

import com.zhwlt.logistics.pojo.Member;

import java.util.List;

public interface IMemberService {
     List<Member> findAll(Member vo);
     int doCreate(Member vo);
     boolean doUpdate(Member vo);
     boolean doDelete(Member vo);
     public Member get(String  ids) ;
}
