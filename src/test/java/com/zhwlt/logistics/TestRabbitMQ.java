package com.zhwlt.logistics;
import com.zhwlt.logistics.service.IMessageProducerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import javax.annotation.Resource;

@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class TestRabbitMQ {
    @Resource
    private IMessageProducerService  messageProducerService;

    @Test
    public  void testSend(){
        for (int i=0;i<900;i++) {
            this.messageProducerService.sendMessage("zhongxi"+i);
        }
    }
    @Test
    public void testStart() throws Exception {
        Thread.sleep(Long.MAX_VALUE);
    }
}
