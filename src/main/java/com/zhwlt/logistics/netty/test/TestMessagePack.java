package com.zhwlt.logistics.netty.test;

import com.zhwlt.logistics.pojo.Member;
import org.msgpack.MessagePack;
import org.msgpack.template.Templates;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 类描述：
 * 创建作者：gt
 * 创建日期 ： 2019/10/14
 */
public class TestMessagePack {
    public static void main(String[] args) throws IOException {
        List<Member> all = new ArrayList<Member>() ;
        for (int x= 0 ; x < 10 ; x ++) {
            Member member = new Member() ;
            member.setName("弱 - " + x);
            member.setAge(10);
            member.setSalary(100.99);
            all.add(member) ;
        }
        MessagePack pack = new MessagePack() ;
        byte[] data = pack.write(all) ; // 写入数据
        {	// 通过二进制数据读取出需要的内容
            List<Member> result = pack.read(data, Templates.tList(pack.lookup(Member.class))) ;
            System.out.println(result);
        }
    }
}
