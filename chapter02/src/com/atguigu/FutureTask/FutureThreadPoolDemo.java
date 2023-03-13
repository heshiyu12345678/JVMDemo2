package com.atguigu.FutureTask;

import java.util.concurrent.*;

/**
 * @Auther: heshiyu
 * @Date: 2023/1/11
 * @Description: com.atguigu.FutureTask
 * @version: 1.0
 */
public class FutureThreadPoolDemo {
    static int a=1;
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        m1();
        ExecutorService executorService= Executors.newFixedThreadPool(3);

        long startTime = System.currentTimeMillis();
        FutureTask futureTask1=new FutureTask(()->{
            try {TimeUnit.MILLISECONDS.sleep(500);} catch(InterruptedException e){e.printStackTrace();}
            return "task1 over";
        });
        executorService.submit(futureTask1);

        FutureTask futureTask2=new FutureTask(()->{
            try {TimeUnit.MILLISECONDS.sleep(400);} catch(InterruptedException e){e.printStackTrace();}
            return "task1 over";
        });
        executorService.submit(futureTask2);

        FutureTask futureTask3=new FutureTask(()->{
            try {TimeUnit.MILLISECONDS.sleep(300);} catch(InterruptedException e){e.printStackTrace();}
            return "task1 over";
        });
        executorService.submit(futureTask3);
        //futureTask1.get();
        while(true){
            if(futureTask1.isDone()){
                System.out.println(futureTask1.get());
                break;
            }else{
                try {TimeUnit.MILLISECONDS.sleep(500);} catch(InterruptedException e){e.printStackTrace();}
                System.out.println("正在处理中！！！");
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("-----costTime:"+(endTime-startTime)+"毫秒");
        executorService.shutdown();

    }

    private static void m1() {
        //3个任务，目前只有一个线程main处理。请问耗时多少？？
        long startTime = System.currentTimeMillis();
        try {TimeUnit.MILLISECONDS.sleep(500);} catch(InterruptedException e){e.printStackTrace();}
        try {TimeUnit.MILLISECONDS.sleep(300);} catch(InterruptedException e){e.printStackTrace();}
        try {TimeUnit.MILLISECONDS.sleep(300);} catch(InterruptedException e){e.printStackTrace();}
        long endTime = System.currentTimeMillis();
        System.out.println("-----costTime:"+(endTime-startTime)+"毫秒");
    }
}
