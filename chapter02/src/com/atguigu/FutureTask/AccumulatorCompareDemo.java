package com.atguigu.FutureTask;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: heshiyu
 * @Date: 2023/2/27
 * @Description: com.atguigu.FutureTask
 * @version: 1.0
 */
class ClikNumber{
    int number=0;
    public synchronized void clikBySynchronized(){
        number++;
    }
    AtomicLong atomicLong=new AtomicLong(0);
    public void clickByAtomicLong(){
        atomicLong.getAndIncrement();
    }
    LongAdder longAdder=new LongAdder();
    public void clickByLongAdder(){
        longAdder.increment();
    }
    LongAccumulator longAccumulator=new LongAccumulator((x,y)->x+y,0);
    public void clickByLongAcc(){
        longAccumulator.accumulate(1);
    }
}
public class AccumulatorCompareDemo {
    //50个线程，每个线程100w次，总数；
    public static final int _1W=10000;
    public static final int threadNum=50;
    public static void main(String[] args) throws InterruptedException{
        ClikNumber clikNumber = new ClikNumber();
        long startTime;
        long endTime;
        CountDownLatch countDownLatch1 = new CountDownLatch(50);
        CountDownLatch countDownLatch2 = new CountDownLatch(50);
        CountDownLatch countDownLatch3 = new CountDownLatch(50);
        CountDownLatch countDownLatch4 = new CountDownLatch(50);
        startTime=System.currentTimeMillis();
        for (int i = 1; i <=50; i++) {
            new Thread(()->{
                for (int j = 1; j <= 1000000; j++) {
                    clikNumber.clikBySynchronized();
                }
                try {
                    countDownLatch1.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
        countDownLatch1.await();
        endTime=System.currentTimeMillis();
        System.out.println("------costTime:"+(endTime-startTime)+"毫秒！"+clikNumber.number);
        startTime=System.currentTimeMillis();
        for (int i = 1; i <=50; i++) {
            new Thread(()->{
                for (int j = 1; j <= 1000000; j++) {
                    clikNumber.clickByAtomicLong();
                }
                try {
                    countDownLatch2.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
        countDownLatch2.await();
        endTime=System.currentTimeMillis();
        System.out.println("------costTime:"+(endTime-startTime)+"毫秒！"+clikNumber.atomicLong);
        startTime=System.currentTimeMillis();
        for (int i = 1; i <=50; i++) {
            new Thread(()->{
                for (int j = 1; j <= 1000000; j++) {
                    clikNumber.clickByLongAdder();
                }
                try {
                    countDownLatch3.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
        countDownLatch3.await();
        endTime=System.currentTimeMillis();
        System.out.println("------costTime:"+(endTime-startTime)+"毫秒！"+clikNumber.longAdder);

        startTime=System.currentTimeMillis();
        for (int i = 1; i <=50; i++) {
            new Thread(()->{
                for (int j = 1; j <= 1000000; j++) {
                    clikNumber.clickByLongAcc();
                }
                try {
                    countDownLatch4.countDown();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }
        countDownLatch4.await();
        endTime=System.currentTimeMillis();
        System.out.println("------costTime:"+(endTime-startTime)+"毫秒！"+clikNumber.longAccumulator);
    }
}
