package com.atguigu.FutureTask;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Auther: heshiyu
 * @Date: 2023/2/26
 * @Description: com.atguigu.FutureTask
 * @version: 1.0
 */
public class SpinLockDemo {
    AtomicReference<Thread> atomicReference=new AtomicReference<>();
    public void lock(){
        Thread thread = Thread.currentThread();
        while(!atomicReference.compareAndSet(null,thread)){

        }
    }
    public void unLock(){
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread,null);
    }
    public static void main(String[] args) {

    }
}
