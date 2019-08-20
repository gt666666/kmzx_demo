package com.zhwlt.logistics;
import com.zhwlt.logistics.controller.MessageController;
import com.zhwlt.logistics.enums.Color;
import com.zhwlt.logistics.enums.ResultEnum;
import com.zhwlt.logistics.mapper.IMemberDAO;
import com.zhwlt.logistics.pojo.Member;
import com.zhwlt.logistics.service.IMemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.json.JsonbTester;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.*;

@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class SampleControllerTest {

//    @Autowired
//    private   SampleController  sampleController;
//    @Test
//   public void testHome(){
//        TestCase.assertEquals(this.sampleController.home(),"baidu.com");//如果和返回结果一样表示测试通过
//    }

    @Autowired
    private MessageController  messageController;
    @Resource
    private DataSource dataSource;
    @Resource
    private IMemberService memberService;
    @Resource
    private IMemberDAO  memberDAO;
    @Test
    public void   testMessage(){
        this.messageController.message("welcome.msg","高挺");
    }
    @Test
    public void   testInfo(){
        this.messageController.info("高挺");
    }
    @Test
    public void getConnection() throws SQLException {
        System.out.println("**********"+dataSource.getConnection());

    }

    @Test
    public void  findBySalary(){
        System.out.println(this.memberDAO.findBySalary(12));
    }
    @Test
    public void findAll() throws Exception {
        Member   vo =new Member();
        vo.setIsDelete(true);
        List<Member>  list=this.memberService.findAll(vo);
        Iterator<Member> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
    @Test
    public void findById() throws Exception {
        System.out.println(this.memberDAO.findById("1"));
    }
    @Test
    public void find() throws Exception {
            Member   vo =new Member();
                vo.setIds("1");
                vo.setCompanySalary(11);
        System.out.println(this.memberDAO.find(vo));
    }
    @Test
    public void findAllByIds() throws Exception {
        List<String>   list=new ArrayList<>();
        list.add("1");
        list.add("12");
        System.out.println(this.memberDAO.findAllByIds(list));
    }
    @Test
    public void findAllBySalary() throws Exception {
        Set<Integer>   set=new HashSet<>();
        set.add(11);
        set.add(12);
        System.out.println(this.memberDAO.findAllBySalary(set));
    }
    @Test
    public void doCreate(){
        Member  member=new Member();
           member.setIds("1234567");
           member.setName("高挺1");
        System.out.println(this.memberService.doCreate(member));

    }
    @Test
    public void doUpdate() {
        Member  member=new Member();
        member.setIds("12345");
        member.setName("nihao");
        System.out.println(this.memberService.doUpdate(member));
    }
    @Test
    public void  doDelete() {
        Member  member=new Member();
        member.setIds("12345");
        System.out.println(this.memberService.doDelete(member));
    }
    @Test
    public void testName(){
        System.out.println(getClass().getSimpleName());
    }

   @Test
    public void testEnum(){
       System.out.println(Color.BLACK);
   }

   @Test
    public void testdoUpdateByNameAndId(){
       Map<String ,String >  map=new HashMap<String ,String >();
       map.put("ids","1");
       map.put("name","高高1234");
       System.out.println(this.memberDAO.doUpdateByNameAndId(map));
   }
   @Test
    public  void  testMap(){
        Map<String ,Object>  map=new HashMap<>();
        map.put("1","你好");
       map.put("2","你好啊");
       System.out.println(map);
   }
}