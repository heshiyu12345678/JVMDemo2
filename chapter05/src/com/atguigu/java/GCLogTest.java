package com.atguigu.java;

import java.util.ArrayList;
import java.util.concurrent.Future;

/**
 * 测试生成详细的日志文件
 * <p>
 * -Xms60m -Xmx60m -XX:SurvivorRatio=8 -XX:+PrintGCDetails -XX:+PrintGCTimeStamps -Xloggc:e:/metaspaceOOM.log -XX:+PrintGCDateStamps -XX:+PrintHeapAtGC
 *
 * @author shkstart
 * @create 14:27
 */
public class GCLogTest {
    public static void main(String[] args) {
        ArrayList<byte[]> list = new ArrayList<>();
        for (int i = 0; i < 5000; i++) {
            byte[] arr = new byte[1024 * 50];//50KB
            list.add(arr);
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}