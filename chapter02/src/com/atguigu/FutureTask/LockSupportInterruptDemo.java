package com.atguigu.FutureTask;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/2
 * @Description: com.atguigu.FutureTask
 * @version: 1.0
 */
public class LockSupportInterruptDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println("线程1正在阻塞");
            System.out.println(Thread.currentThread().isInterrupted());
            LockSupport.park();
            System.out.println(Thread.currentThread().isInterrupted());
            System.out.println("线程1倍打断");
        });
        thread.start();
        try {
            TimeUnit.MILLISECONDS.sleep(500);} catch(InterruptedException e){e.printStackTrace();}
        new Thread(()->{
            thread.interrupt();
            //LockSupport.unpark(thread);
        }).start();
    }
}
