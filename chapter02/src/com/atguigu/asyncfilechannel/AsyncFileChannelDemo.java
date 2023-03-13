package com.atguigu.asyncfilechannel;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.Future;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/4
 * @Description: com.atguigu.asyncfilechannel
 * @version: 1.0
 */
public class AsyncFileChannelDemo {
    @Test
    public void readAsync() throws IOException {
        //创建一个AsynchronousFileChannel对象
        Path path= Paths.get("e:\\a.txt");
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer= ByteBuffer.allocate(1024);
        Future<Integer> future = fileChannel.read(buffer, 0);
        //判断操作是否完成isDone，返回true
        while(!future.isDone());
        buffer.flip();
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        System.out.println(new String(bytes));
        buffer.clear();
    }
    @Test
    public void readAsyncComp() throws IOException {
        //创建一个AsynchronousFileChannel对象
        Path path= Paths.get("e:\\a.txt");
        AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, StandardOpenOption.READ);
        ByteBuffer buffer= ByteBuffer.allocate(1024);
        fileChannel.read(buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
            @Override
            public void completed(Integer result, ByteBuffer attachment) {
                System.out.println("result:"+result);
                attachment.flip();
                byte[] bytes = new byte[attachment.limit()];
                attachment.get(bytes);
                System.out.println(new String(bytes));
                buffer.clear();
            }

            @Override
            public void failed(Throwable exc, ByteBuffer attachment) {

            }
        });

    }
}
