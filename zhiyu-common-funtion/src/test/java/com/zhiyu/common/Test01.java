package com.zhiyu.common;

import com.zhiyu.common.thread.ThreadFactory;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author wengzhiyu
 * @date 2020/12/4
 */
@Slf4j
public class Test01 {

    @Test
    public void test() {

//        Thread thread1=new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("2222");
//                System.out.println("ThresdName---"+Thread.currentThread().getName());
//                for (int i = 0; i <10 ; i++) {
//                }
//            }
//        });
//        thread1.start();
    }

    @Test
    public void testThread() {
        ThreadFactory.init();
        ExecutorService executor = ThreadFactory.getFirstExecutor();
        executor.submit(this::send);
        //send();
        System.out.println("结束了");
    }


    private void send() {
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("线程名字:" + Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
