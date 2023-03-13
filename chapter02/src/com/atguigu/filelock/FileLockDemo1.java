package com.atguigu.filelock;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/4
 * @Description: com.atguigu.filelock
 * @version: 1.0
 */
public class FileLockDemo1 {
    public static void main(String[] args) throws IOException {
        String input="atguigu";
        System.out.println(input);
        ByteBuffer buffer=ByteBuffer.wrap(input.getBytes());
        String filePath="e:\\a.txt";
        Path path= Paths.get(filePath);
        FileChannel channel=FileChannel.open(path, StandardOpenOption.WRITE,StandardOpenOption.APPEND);
        channel.position(channel.size()-1);
        FileLock lock= channel.lock(0L,Long.MAX_VALUE,true);
        System.out.println("是否共享锁："+lock.isShared());

        channel.write(buffer);
        channel.close();

        //读文件
        readFile(filePath);

    }

    private static void readFile(String filePath) throws IOException {
        FileReader fileReader=new FileReader(filePath);
        BufferedReader bufferedReader=new BufferedReader(fileReader);
        String s = bufferedReader.readLine();
        System.out.println("读取：");
        while (s!=null){
            System.out.println(""+s);
            s=bufferedReader.readLine();
        }
        bufferedReader.close();
        fileReader.close();
    }
}
