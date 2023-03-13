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
public class FileChannelDemo1 {
    //filechannel读取数据到buffer中
    public static void main(String[] args) throws Exception {
        //创建一个FileChannel
        RandomAccessFile aFile=new RandomAccessFile("e:\\a.txt","rw");
        FileChannel channel = aFile.getChannel();
        //创建buffer
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        //读取数据到buffer中
        int read = channel.read(buffer);//返回读取的字节数
        while (read!=-1){
            System.out.println("读取了"+read);
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.println((char)buffer.get());
            }
            buffer.clear();
            read=channel.read(buffer);
        }
        aFile.close();
        System.out.println("操作结束了");
    }
}
