package com.atguigu.path;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/4
 * @Description: com.atguigu.path
 * @version: 1.0
 */
public class PathDemo1 {
    public static void main(String[] args) {
        //创建Path实例
        Path path = Paths.get("e:\\a.txt");
        //相对路径
        Path rpojects = Paths.get("e:\\a.txt", "rpojects");
        //
        //
    }
}
