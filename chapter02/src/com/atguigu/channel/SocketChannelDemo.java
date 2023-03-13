package com.atguigu.channel;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/4
 * @Description: com.atguigu.channel
 * @version: 1.0
 */
public class SocketChannelDemo {
    public static void main(String[] args) throws Exception {
        //创建SocketChannel
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("www.baidu.com", 80));
        //第二种连接方式
//        SocketChannel open1 = SocketChannel.open();
//        open1.connect(new InetSocketAddress("www.baidu.com", 80));
//        //连接校验
        System.out.println(socketChannel.isOpen());
        System.out.println(socketChannel.isConnected());
        System.out.println(socketChannel.isConnectionPending());
        System.out.println(socketChannel.finishConnect());
        //支持阻塞模式和非阻塞模式
        socketChannel.configureBlocking(false);

    }
}
