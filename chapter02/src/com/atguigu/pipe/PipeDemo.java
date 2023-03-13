package com.atguigu.pipe;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/4
 * @Description: com.atguigu.pipe
 * @version: 1.0
 */
public class PipeDemo {
    public static void main(String[] args) throws Exception {
        //获取管道
        Pipe pipe = Pipe.open();
        //获取sinkchannel
        Pipe.SinkChannel sinkChannel = pipe.sink();
        //创建缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        byteBuffer.put("atguigu".getBytes());
        byteBuffer.flip();
        //写入数据到sinkChannel
        sinkChannel.write(byteBuffer);
        //获取sourceChannel
        Pipe.SourceChannel sourceChannel = pipe.source();
        //创建缓冲区读取数据
        ByteBuffer byteBuffer2 = ByteBuffer.allocate(1024);
        int lenght = sourceChannel.read(byteBuffer2);
        System.out.println(new String(byteBuffer2.array(),0,lenght));
        //关闭通道
        sourceChannel.close();
        sinkChannel.close();
    }
}
