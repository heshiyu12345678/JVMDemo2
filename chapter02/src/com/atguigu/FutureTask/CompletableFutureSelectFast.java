package com.atguigu.FutureTask;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Auther: heshiyu
 * @Date: 2023/2/24
 * @Description: com.atguigu.FutureTask
 * @version: 1.0
 */
public class CompletableFutureSelectFast {
    public static void main(String[] args) {
        CompletableFuture<String> playA = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "playA";
        });
        CompletableFuture<String> playB = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.MILLISECONDS.sleep(600);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "playB";
        });
        CompletableFuture<String> completableFuture = playA.applyToEither(playB, f -> {
            return f + "is winner";
        });
        System.out.println(completableFuture.join());
    }
}
