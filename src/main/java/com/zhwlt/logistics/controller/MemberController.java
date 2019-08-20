package com.zhwlt.logistics.controller;

import com.zhwlt.logistics.controller.abs.AbstractBaseController;
import com.zhwlt.logistics.pojo.Member;
import com.zhwlt.logistics.service.IMemberService;
import com.zhwlt.logistics.service.IMessageService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Iterator;
import java.util.List;

@Controller  //作为一个控制层的切面处理
public class MemberController extends AbstractBaseController {
    @Resource
    private IMemberService memberService;
    @GetMapping(value = "/addPre")
    public String addPre(){
        return  "member_add";
    }
    @GetMapping(value = "/list")
    public String list(){
        return  "vue_base";
    }
    @PostMapping(value = "/add")
    @ResponseBody
    public  Object     add(@Valid Member  vo  , BindingResult result){
        if (result.hasErrors()) { // 现在表示执行的验证出现错误
            Iterator<ObjectError> iterator = result.getAllErrors().iterator(); // 获取全部错误信息
            while (iterator.hasNext()) {
                ObjectError error = iterator.next() ;	// 取出每一个错误
                System.out.println("【错误信息】code = " + error.getCode() + "，message = " + error.getDefaultMessage());
            }
            return result.getAllErrors() ;
        } else {
            return vo;
        }
    }
    @RequestMapping(value = "/member_add_pre", method = RequestMethod.GET)
    public String memberAddPre() {
        System.out.println("!!!!!!!!!!!!!!!!!!!!!!!");
        return "member_add";
    }
    @RequestMapping(value = "/member_add", method = RequestMethod.POST)
    @ResponseBody
    public Object memberAdd(Member member) {
        System.out.println("+++++++++++++++++++");
        return member ;
    }
    @RequestMapping(value = "/member_get",method = RequestMethod.GET)
    @ResponseBody
    public Object  get(String ids){
        return   this.memberService.get(ids);
    }

    @PostMapping(value = "/member/list")
    @ResponseBody
    public List<Member> listAll(String dname ,String loc){
        System.out.println("***********************"+dname+"****************"+loc);
       // return this.memberService.findAll();
        return  null;
    }

}
