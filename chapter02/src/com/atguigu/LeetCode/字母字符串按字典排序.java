package com.atguigu.LeetCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/6
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 字母字符串按字典排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] str=new String[Integer.valueOf(in.nextLine())];
        for (int i = 0; i < str.length; i++) {
            str[i]=in.nextLine();
        }
        Arrays.sort(str);
        for (int i = 0; i < str.length; i++) {
            System.out.println(str[i]);
        }

    }
}
