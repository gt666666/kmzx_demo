package com.zhwlt.logistics;

import com.zhwlt.logistics.pojo.Member;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import javax.annotation.Resource;

@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestRedis {
    @Resource
    private RedisTemplate<String ,String>  redisTemplate;

    @Resource
    private Member member;
    @Test
    public   void testSet1(){
         this.redisTemplate.opsForValue().set("zhs","www.baidu.com");
        System.out.println(this.redisTemplate.opsForValue().get("zhs"));
    }

    @Test
    public void testGet() {
        System.out.println(this.redisTemplate.opsForValue().get("zhs"));
    }

    @Test
    public void testSet2() {
        Member vo = new Member();
        vo.setIds("11112");
        vo.setName("中国");
        this.redisTemplate.opsForValue().set("zg", String.valueOf(vo));
        System.out.println(this.redisTemplate.opsForValue().get("zg"));
    }
    @Test
    public void testMember(){
        System.out.println(this.member.getName());
    }
}
