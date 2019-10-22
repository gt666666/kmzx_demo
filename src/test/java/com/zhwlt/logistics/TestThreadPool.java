package com.zhwlt.logistics;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.*;

/**
 * 类描述：
 * 创建作者：gt
 * 创建日期 ： 2019/9/14
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestThreadPool {
    @org.junit.Test
    public void testNewCachedThreadPool1() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(1000);
        ExecutorService service = Executors.newCachedThreadPool();//创建一个无线大小的线程池
        for (int x = 0; x < 1000; x++) {
//            service.submit(()->{
//                System.out.println(Thread.currentThread().getName()+"    "+latch.getCount());
//                latch.countDown();
//            });  //不在使用Thread启动多线程，全部交由线程池来负责启动
        }
        latch.await();// 进入阻塞状态，等待计数归0
    }

    @org.junit.Test
    public void testNewFixedThreadPool() throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int x = 0; x < 10; x++) {
//            service.submit(()->{
//                System.out.println(Thread.currentThread().getName()+"    "+latch.getCount());
//                latch.countDown();
//            });  //不在使用Thread启动多线程，全部交由线程池来负责启动
        }
        latch.await();// 进入阻塞状态，等待计数归0
        System.out.println(11);
    }

    @org.junit.Test
    public void testNewScheduledThreadPool() {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(3); // 创建一个线程调度池
        for (int x = 0; x < 3; x++) {
//            service.scheduleAtFixedRate(()->{
//                System.out.println("【"+Thread.currentThread().getName()+"】线程任务执行。");
//            },3,2,TimeUnit.SECONDS) ; // 3秒后开始执行，每2秒执行一次
//        }
        }
    }
}





