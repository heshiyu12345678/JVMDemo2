package com.atguigu.FutureTask;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Auther: heshiyu
 * @Date: 2023/1/18
 * @Description: com.atguigu.FutureTask
 * @version: 1.0
 */
class MyNumber{
     int number;
    public void addPlusplus(){
        number++;
    }
}
public class Test {
    public static void main(String[] args) {
        MyNumber myNumber=new MyNumber();
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    myNumber.addPlusplus();
                }
            }).start();
        }
        try {TimeUnit.SECONDS.sleep(2);} catch(InterruptedException e){e.printStackTrace();}
        System.out.println(myNumber.number);
    }
}
