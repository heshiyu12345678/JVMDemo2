package com.atguigu.FutureTask;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.LockSupport;

/**
 * @Auther: heshiyu
 * @Date: 2023/1/11
 * @Description: com.atguigu.FutureTask
 * @version: 1.0
 */
public class CompletableFutureDemo {
    static AtomicBoolean atomicBoolean=new AtomicBoolean(false);
    public static void main(String[] args) {
        Thread t1=new Thread(()->{
            while(true){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("interrupt被设置为true");
                    break;
                }
                System.out.println("interrupt为false");
                try{
                    Thread.sleep(200);
                }catch (InterruptedException e){
                    Thread.currentThread().interrupt();//
                    e.printStackTrace();
                }
            }
        },"t1");
        t1.start();
        try {TimeUnit.MILLISECONDS.sleep(1000);} catch(InterruptedException e){e.printStackTrace();}
        new Thread(()->{
            t1.interrupt();
        }).start();
    }
}

class NetMall{

    private String netMallName;

}