package com.atguigu.FutureTask;

import java.util.concurrent.CountDownLatch;

/**
 * @Auther: heshiyu
 * @Date: 2023/2/27
 * @Description: com.atguigu.FutureTask
 * @version: 1.0
 */
public class CountDownLatchDemo2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"号同学离开了教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"：锁门");
    }
}
