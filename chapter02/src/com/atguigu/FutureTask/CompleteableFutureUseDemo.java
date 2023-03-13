package com.atguigu.FutureTask;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;

/**
 * @Auther: heshiyu
 * @Date: 2023/1/31
 * @Description: com.atguigu.FutureTask
 * @version: 1.0
 */
public class CompleteableFutureUseDemo {
    public static void main(String[] args) {
        Supplier<String> supplier = new Supplier<String>() {
            @Override
            public String get() {
                return null;
            }
        };
        CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"----come in");
            int result= ThreadLocalRandom.current().nextInt(10);
            try {TimeUnit.MILLISECONDS.sleep(500);} catch(InterruptedException e){e.printStackTrace();}
            System.out.println("----500毫秒后出结果："+result);
            return result;
        }).whenComplete((v,e)->{
            if(e==null){
                System.out.println("计算完成，计算值为："+v);
            }
        }).exceptionally(e->{
            e.printStackTrace();
            System.out.println("发生异常"+e.getCause()+e.getMessage());
            return null;
        });
        System.out.println("主线程去忙其他任务了");
        //主线程不要立刻结束，否则completeableFuture默认使用的线程池会立即关闭；
        try {TimeUnit.SECONDS.sleep(3);} catch(InterruptedException e){e.printStackTrace();}
    }
}
