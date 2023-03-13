package com.atguigu.FutureTask;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Auther: heshiyu
 * @Date: 2023/2/27
 * @Description: com.atguigu.FutureTask
 * @version: 1.0
 */
public class CyclicBarrierDemo {
    //集齐7颗龙珠召唤神龙
    private static final int NUMBER=7;
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(NUMBER,()->{
            System.out.println("集齐7颗龙珠了神龙出现");
        });
        //集齐7颗龙珠的过程
        for (int i = 1; i <=14; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"颗龙珠被找到");
                try {
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
    }
}
