package com.atguigu.selector;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/4
 * @Description: com.atguigu.selector
 * @version: 1.0
 */
public class SelectorDemo2 {
    //客户端代码
    @Test
    public void clientDemo() throws Exception {
        //获取通道绑定主机和端口号
        SocketChannel socketChannel=SocketChannel.open(new InetSocketAddress("127.0.0.1",8080));
        //切换到非阻塞模式
        socketChannel.configureBlocking(false);
        //创建buffer
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        //写入buffer数据
        buffer.put(new Date().toString().getBytes());
        //buffer模式切换
        buffer.flip();
        //写入通道
        socketChannel.write(buffer);
        //清空关闭通道
        buffer.clear();
    }

    //服务端
    @Test
    public void serverDemo() throws Exception {
        //获取服务通道
        ServerSocketChannel serverSocketChannel=ServerSocketChannel.open();
        //切换为非阻塞模式
        serverSocketChannel.configureBlocking(false);
        //创建buffer
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        //绑定端口号
        serverSocketChannel.bind(new InetSocketAddress(8080));
        //获取selector选择器
        Selector selector=Selector.open();
        //通道注册到选择器上，进行监听
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //选择器进行轮询。进行后续操作。
        while (selector.select()>0){
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while(iterator.hasNext()){
                SelectionKey next = iterator.next();
                if(next.isAcceptable()){
                    //获取连接
                    SocketChannel accept=serverSocketChannel.accept();
                    //切换非阻塞模式
                    accept.configureBlocking(false);
                    //注册
                    accept.register(selector,SelectionKey.OP_READ);

                }else if(next.isReadable()){
                    SocketChannel socketChannel=(SocketChannel)next.channel();
                    ByteBuffer byteBuffer=ByteBuffer.allocate(1024);
                    int length=0;
                    while((length=socketChannel.read(byteBuffer))>0){
                        socketChannel.read(buffer);
                        //buffer切换成读模式
                        buffer.flip();
                        System.out.println("接收到："+new String(buffer.array(),0,length));
                        byteBuffer.clear();
                    }

                }
            }
            iterator.remove();
        }
    }

    public static void main(String[] args) throws Exception {
        //获取通道绑定主机和端口号
        SocketChannel socketChannel=SocketChannel.open(new InetSocketAddress("127.0.0.1",8080));
        //切换到非阻塞模式
        socketChannel.configureBlocking(false);
        //创建buffer
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        Scanner scanner=new Scanner(System.in);
        while (scanner.hasNext()){
            String next = scanner.next();
            //写入buffer数据
            buffer.put((new Date().toString()+next).getBytes());
            //buffer模式切换
            buffer.flip();
            //写入通道
            socketChannel.write(buffer);
            //清空关闭通道
            buffer.clear();
        }

    }
}
