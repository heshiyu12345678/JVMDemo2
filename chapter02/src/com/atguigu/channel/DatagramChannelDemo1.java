package com.atguigu.channel;

import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/4
 * @Description: com.atguigu.channel
 * @version: 1.0
 */
public class DatagramChannelDemo1 {
    //发送的实现
    @Test
    public void sendDatagram() throws Exception {
        //打开channel
        DatagramChannel sendChannel = DatagramChannel.open();
        InetSocketAddress sendAdderss=new InetSocketAddress("127.0.0.1",9999);
        //发送
        while(true){
            ByteBuffer buffer=ByteBuffer.wrap("发送gatguigu".getBytes(StandardCharsets.UTF_8));
            sendChannel.send(buffer,sendAdderss);
            System.out.println("已经完成发送");
            Thread.sleep(2000);
        }
    }
    //接收到而实现
    @Test
    public void receiveDatagram() throws Exception {
        //打开channel
        DatagramChannel reveiveChannel=DatagramChannel.open();
        InetSocketAddress reveiveAdderss=new InetSocketAddress(9999);
        //绑定
        reveiveChannel.bind(reveiveAdderss);
        //创建一个buffer
        ByteBuffer receiveBuffer=ByteBuffer.allocate(1024);
        //接收
        while(true){
            receiveBuffer.clear();
            SocketAddress socketAddress = reveiveChannel.receive(receiveBuffer);
            receiveBuffer.flip();
            System.out.println(socketAddress.toString());
            System.out.println(Charset.forName("UTF-8").decode(receiveBuffer));
        }
    }
    //连接过程read，write
    @Test
    public void testConnect() throws IOException {
        DatagramChannel connChannel = DatagramChannel.open();
        //绑定
        connChannel.bind(new InetSocketAddress(9999));
        //创建连接
        connChannel.connect(new InetSocketAddress("127.0.0.1",9999));
        //write方法
        connChannel.write(ByteBuffer.wrap("发送gatguigu".getBytes(StandardCharsets.UTF_8)));
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        while(true){
            buffer.clear();
            connChannel.read(buffer);
            buffer.flip();
            System.out.println(Charset.forName("UTF-8").decode(buffer));
        }
    }
}
