package com.atguigu.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/4
 * @Description: com.atguigu.channel
 * @version: 1.0
 */
public class ServerSocketChannelDemo1 {
    public static void main(String[] args) throws Exception {
        //buffer
        ByteBuffer buffer = ByteBuffer.wrap("helo atguigu".getBytes());
        //创建ServerSocketChannel
        ServerSocketChannel ssc=ServerSocketChannel.open();
        //绑定
        ssc.socket().bind(new InetSocketAddress(8888));
        //设置非阻塞模式
        ssc.configureBlocking(false);
        //监听是否有新连接
        while (true){
            System.out.println("正在等待连接中。。。。。");
            SocketChannel accept = ssc.accept();//如果是阻塞模式这里会被阻塞知道有连接进来
            if(accept==null){//没有连接的传入
                System.out.println("null");
                Thread.sleep(2000);
            }else{
                System.out.println(accept.socket().getRemoteSocketAddress());
                buffer.rewind();//指针指向0
                accept.write(buffer);
                accept.close();
            }
        }
    }
}
