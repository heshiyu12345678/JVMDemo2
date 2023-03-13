package com.atguigu.maven;

import org.junit.Test;

/**
 * @Auther: heshiyu
 * @Date: 2023/2/4
 * @Description: com.atguigu.maven
 * @version: 1.0
 */
public class HelloMavenTest {
    @Test
    public void testHelloMaven(){
        Object ob=new Object();
        new Thread(()->{
            synchronized (ob){
                System.out.println("dsd");
                System.out.println("dsd");
                System.out.println("dsd");
                synchronized (ob){
                    System.out.println("dsd");
                }
            }
        }).start();
    }
}
