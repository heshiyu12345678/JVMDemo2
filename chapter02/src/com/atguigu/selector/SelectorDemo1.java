package com.atguigu.selector;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/4
 * @Description: com.atguigu.selector
 * @version: 1.0
 */
public class SelectorDemo1 {
    public static void main(String[] args) throws Exception {
        //创建selector对象
        Selector selector = Selector.open();
        //创建一个通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //非阻塞
        serverSocketChannel.configureBlocking(false);
        //绑定连接
        serverSocketChannel.bind(new InetSocketAddress(9999));
        //将通道注册到Selector
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        //查询已经就绪的通道操作。
        Set<SelectionKey> selectionKeys = selector.selectedKeys();
        //遍历集合
        Iterator<SelectionKey> iterator = selectionKeys.iterator();
        while(iterator.hasNext()){
            SelectionKey next = iterator.next();
            //判断key就绪状态操作
            if(next.isAcceptable()){

            }else if(next.isConnectable()){

            }else if(next.isReadable()){

            }else if(next.isWritable()){

            }else if(next.isValid()){

            }
            iterator.remove();
        }
    }
}
