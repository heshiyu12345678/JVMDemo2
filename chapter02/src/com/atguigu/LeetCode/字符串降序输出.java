package com.atguigu.LeetCode;

import java.util.Scanner;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/6
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 字符串降序输出 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str=in.nextLine();
        for(int i=str.length();i>=0;i--){
            System.out.print(str.charAt(i));
        }
    }
}
