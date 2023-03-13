package com.atguigu.FutureTask;

/**
 * @Auther: heshiyu
 * @Date: 2023/2/4
 * @Description: com.atguigu.FutureTask
 * @version: 1.0
 */
public class Debug06 {
    public static void main(String[] args) {
        test("thread1");
        test("thread2");
    }
    public static void test(String threadName){
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println(Thread.currentThread().getName());
            }
        },threadName).start();
    }
}
