package com.atguigu.FutureTask;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/**
 * @Auther: heshiyu
 * @Date: 2023/2/26
 * @Description: com.atguigu.FutureTask
 * @version: 1.0
 */
class MyVar{
    public volatile Boolean isInit=Boolean.FALSE;
    AtomicReferenceFieldUpdater<MyVar, Boolean> referenceFieldUpdater=
            AtomicReferenceFieldUpdater.newUpdater(MyVar.class,Boolean.class,"isInit");
    public void init(MyVar myVar){
        if (referenceFieldUpdater.compareAndSet(myVar,Boolean.FALSE,Boolean.TRUE)) {
            System.out.println("come in");
            try {TimeUnit.MILLISECONDS.sleep(2000);} catch(InterruptedException e){e.printStackTrace();}
            System.out.println("over init");
        }else{
            System.out.println("其他线程正在进行初始化工作");
        }
    }
}
public class AtomicReferenceFieldUpdaterDemo {
    public static void main(String[] args) {
        MyVar myVar = new MyVar();
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                myVar.init(myVar);
            }).start();
        }
    }
}
