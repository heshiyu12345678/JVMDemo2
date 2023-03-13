package com.atguigu.buffer;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/4
 * @Description: com.atguigu.buffer
 * @version: 1.0
 */
public class BufferDemo2 {
    @Test
    public void buffer01(){
        ByteBuffer buffer= ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte)i);
        }
        //创建一个字缓冲区
        buffer.position(3);
        buffer.limit(7);
        ByteBuffer slice = buffer.slice();
        //改变子缓冲区的内容
        for (int i = 0; i < slice.capacity(); i++) {
            byte b = slice.get(i);
            b*=10;
            slice.put(i,b);
        }
        buffer.position(0);
        buffer.limit(buffer.capacity());

        while(buffer.remaining()>0){
            System.out.println(buffer.get());
        }
    }
    @Test
    public void buffer02(){
        ByteBuffer buffer= ByteBuffer.allocate(10);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put((byte)i);
        }
        //创建一个只读的缓冲区
        ByteBuffer readBuffer = buffer.asReadOnlyBuffer();
        for (int i = 0; i < buffer.capacity(); i++) {
            byte b = buffer.get(i);
            b*=10;
            buffer.put(i,b);
        }
        readBuffer.position(0);
        readBuffer.limit(buffer.capacity());
        while(readBuffer.remaining()>0){
            System.out.println(readBuffer.get());
        }
    }
    @Test
    public void buffer03() throws Exception {
        String infile="e:\\a.txt";
        FileInputStream fileInputStream = new FileInputStream(infile);
        FileChannel channel = fileInputStream.getChannel();

        String outfile="e:\\b.txt";
        FileOutputStream outputStream = new FileOutputStream(outfile);
        FileChannel channel2 = outputStream.getChannel();
        //创键直接缓冲区：
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        while(true){
            buffer.clear();

            int read = channel.read(buffer);
            if(read==-1){
                break;
            }
            buffer.flip();
            channel2.write(buffer);
        }
    }
    @Test
    public void buffer04() throws Exception{
        RandomAccessFile aFile=new RandomAccessFile("E:\\a.txt","rw");
        FileChannel channel = aFile.getChannel();
        MappedByteBuffer map = channel.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
        map.put(0,(byte)97);
        map.put(1023,(byte)122);
        aFile.close();
    }
}
