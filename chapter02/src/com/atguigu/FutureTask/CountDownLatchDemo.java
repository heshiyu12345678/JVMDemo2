package com.atguigu.FutureTask;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: heshiyu
 * @Date: 2023/2/26
 * @Description: com.atguigu.FutureTask
 * @version: 1.0
 */
public class CountDownLatchDemo {
    public static final int SIZE=50;
    public static void main(String[] args) throws InterruptedException {
        CountDownLatchDemo countDownLatchDemo=new CountDownLatchDemo();
        CountDownLatch countDownLatch=new CountDownLatch(50);
        for (int i = 0; i < 50; i++) {
            new Thread(()->{
                try {
                    for (int j=1;j<=1000;j++){
                        System.out.println("GGGG");
                    }
                } finally {
                    countDownLatch.countDown();
                }
            }).start();
        }
       // try {TimeUnit.MILLISECONDS.sleep(500);} catch(InterruptedException e){e.printStackTrace();}
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t"+"jieshu");
    }
}
