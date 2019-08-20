package com.zhwlt.logistics.service.impl;

import com.zhwlt.logistics.mapper.IMemberDAO;
import com.zhwlt.logistics.pojo.Member;
import com.zhwlt.logistics.service.IMemberService;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
public class MemberServiceImpl implements IMemberService {
    @Autowired
    private IMemberDAO memberDAO;
    @Override
    public  List<Member> findAll( Member vo) {
        List<Member> members = null;
        try {
            members = this.memberDAO.findAll(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return members;
    }

    @Override
    public int doCreate(Member vo) {
        try {
            return this.memberDAO.doCreate(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public boolean doUpdate(Member vo) {
        try {
            return this.memberDAO.doUpdate(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean doDelete(Member vo) {

        try {
            return this.memberDAO.doDelete(vo);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public Member get(String ids) {
        Member vo = new Member();
        vo.setIds(ids);
        vo.setName("KING");
        return vo;
    }


}
