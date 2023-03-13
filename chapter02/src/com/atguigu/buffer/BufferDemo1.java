package com.atguigu.buffer;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/4
 * @Description: com.atguigu.buffer
 * @version: 1.0
 */
public class BufferDemo1 {
    @Test
    public void buffer01() throws IOException {
        //打开channel
        RandomAccessFile aFile=new RandomAccessFile("E:\\a.txt","rw");
        FileChannel channel = aFile.getChannel();
        //创建buffer
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        int pos = channel.read(buffer);
        while(pos!=-1){
            buffer.flip();
            while (buffer.hasRemaining()){
                System.out.println((char)buffer.get());
            }
            buffer.clear();
            pos= channel.read(buffer);
            //test
            //san
            //hot-fix
        }
        channel.close();
    }

    @Test
    public void buffer02(){
        IntBuffer buffer=IntBuffer.allocate(8);
        for (int i = 0; i < buffer.capacity(); i++) {
            int j=2*(i+1);
            buffer.put(j);
        }
        buffer.flip();
        while (buffer.hasRemaining()) {
            int value=buffer.get();
            System.out.println(value+"");
        }
    }
}
