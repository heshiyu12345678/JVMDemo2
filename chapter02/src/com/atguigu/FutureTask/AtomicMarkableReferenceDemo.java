package com.atguigu.FutureTask;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @Auther: heshiyu
 * @Date: 2023/2/26
 * @Description: com.atguigu.FutureTask
 * @version: 1.0
 */
public class AtomicMarkableReferenceDemo {
    static AtomicMarkableReference markableReference=new AtomicMarkableReference(100,true);
    public static void main(String[] args) {
        new Thread(()->{
            boolean marked = markableReference.isMarked();
            System.out.println(Thread.currentThread().getName()+"\t"+"默认标识："+marked);
            try {TimeUnit.MILLISECONDS.sleep(500);} catch(InterruptedException e){e.printStackTrace();}
            markableReference.compareAndSet(100,1000,marked,!marked);
        }).start();
        new Thread(()->{
            boolean marked = markableReference.isMarked();
            System.out.println(Thread.currentThread().getName()+"\t"+"默认标识："+marked);
            try {TimeUnit.MILLISECONDS.sleep(500);} catch(InterruptedException e){e.printStackTrace();}
            boolean b = markableReference.compareAndSet(100, 2000, marked, !marked);
            System.out.println("t2"+b+markableReference.isMarked()+markableReference.getReference());
        }).start();
    }
}
