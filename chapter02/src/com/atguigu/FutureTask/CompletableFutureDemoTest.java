package com.atguigu.FutureTask;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/2
 * @Description: com.atguigu.FutureTask
 * @version: 1.0
 */
public class CompletableFutureDemoTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
//            try {
//                TimeUnit.MILLISECONDS.sleep(500);} catch(InterruptedException e){e.printStackTrace();}
//            System.out.println("进入异步方法体");
//            return "heshiyu";
//        });
//        String s = completableFuture.get();
//        System.out.println(s);
        System.out.println("ddddddd");
        new Thread(()->{
            System.out.println("dsdsdsd");
        },"t1").start();
        System.out.println("dsdsdsd");
        new Thread(()->{
            System.out.println("dsdsdsd");
        },"t2").start();
    }
}
