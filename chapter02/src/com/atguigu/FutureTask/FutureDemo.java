package com.atguigu.FutureTask;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Auther: heshiyu
 * @Date: 2023/1/10
 * @Description: com.atguigu.FutureTask
 * @version: 1.0
 */
public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask=new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("----come in call()");
                return "hello callable";
            }
        });
        Thread t1=new Thread(futureTask,"t1");
        t1.start();
        System.out.println(futureTask.get());
    }
}
