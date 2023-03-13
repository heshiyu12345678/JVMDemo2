package com.atguigu.channel;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/4
 * @Description: com.atguigu.channel
 * @version: 1.0
 */
public class FileChannelDemo2 {
    public static void main(String[] args) throws Exception {
        //打开一个channel
        RandomAccessFile aFile=new RandomAccessFile("E:\\a.txt","rw");
        FileChannel channel = aFile.getChannel();
        //创建一个buffer
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        String newData="data atguigu";
        buffer.clear();
        //写入数据
        buffer.put(newData.getBytes());
        buffer.flip();
        //FileChannel最终实现
        while(buffer.hasRemaining()){
            channel.write(buffer);
        }
        //关闭channel
        channel.close();
    }
}
