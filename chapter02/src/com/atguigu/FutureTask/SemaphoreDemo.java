package com.atguigu.FutureTask;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: heshiyu
 * @Date: 2023/2/27
 * @Description: com.atguigu.FutureTask
 * @version: 1.0
 */
public class SemaphoreDemo {
    //6辆汽车停到3个停车位
    public static void main(String[] args) {
        Semaphore semaphore=new Semaphore(3);
        for (int i = 1; i <=6 ; i++) {
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"车获得门票进入停车位");
                    try {TimeUnit.MILLISECONDS.sleep(500);} catch(InterruptedException e){e.printStackTrace();}
                    System.out.println(Thread.currentThread().getName()+"车离开停车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }

            },String.valueOf(i)).start();
        }
    }
}
