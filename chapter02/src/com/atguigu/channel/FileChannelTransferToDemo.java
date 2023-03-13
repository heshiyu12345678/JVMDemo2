package com.atguigu.channel;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/4
 * @Description: com.atguigu.channel
 * @version: 1.0
 */
public class FileChannelTransferToDemo {
    public static void main(String[] args) throws Exception {
        //创建两个FileChannel
        RandomAccessFile aFile1=new RandomAccessFile("e:\\a.txt","rw");
        FileChannel channel1 = aFile1.getChannel();
        RandomAccessFile aFile2=new RandomAccessFile("e:\\b.txt","rw");
        FileChannel channel2 = aFile2.getChannel();
        //channel1的数据传到channel2中
        channel1.transferTo(0,channel1.size(),channel2);
        channel1.close();
        channel2.close();
        System.out.println("over");
    }
}
