package com.atguigu.FutureTask;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @Auther: heshiyu
 * @Date: 2023/2/24
 * @Description: com.atguigu.FutureTask
 * @version: 1.0
 */
public class CompletableFutureCombine {
    public static void main(String[] args) {
        CompletableFuture<Integer> com1 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 10;
        });
        CompletableFuture<Integer> com2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "启动");
            try {
                TimeUnit.MILLISECONDS.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 20;
        });
        CompletableFuture<Integer> completableFuture = com1.thenCombine(com2, (f1, f2) -> {
            return f1 + f2;
        });
        System.out.println(completableFuture.join());
    }
}
