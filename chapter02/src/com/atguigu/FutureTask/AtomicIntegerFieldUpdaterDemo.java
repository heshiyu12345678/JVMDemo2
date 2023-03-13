package com.atguigu.FutureTask;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Auther: heshiyu
 * @Date: 2023/2/26
 * @Description: com.atguigu.FutureTask
 * @version: 1.0
 */
class Bank{
    String bankName="CCB";
    public volatile int money=0;
    public void add(){
        money++;
    }
    AtomicIntegerFieldUpdater<Bank> atomicIntegerFieldUpdater=
            AtomicIntegerFieldUpdater.newUpdater(Bank.class,"money");
    public void transMoney(Bank bank){
        atomicIntegerFieldUpdater.getAndIncrement(bank);
    }
}
public class AtomicIntegerFieldUpdaterDemo {
    public static void main(String[] args) throws InterruptedException {
        Bank bank=new Bank();
        CountDownLatch countDownLatch=new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                try {
                    for (int j = 0; j < 1000; j++) {
                        bank.transMoney(bank);
                    }
                } finally {
                    countDownLatch.countDown();
                }
            }).start();
        }
        countDownLatch.await();
        System.out.println(bank.money);
    }
}
