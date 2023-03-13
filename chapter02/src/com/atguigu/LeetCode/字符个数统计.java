package com.atguigu.LeetCode;

import java.util.*;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/5
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 字符个数统计 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        String str=in.nextLine();
        TreeSet<Character> set=new TreeSet<>();
        int length=str.length();
        for(int i=0;i<length;i++){
            set.add(str.charAt(i));
        }
        System.out.println(set.size());
    }
}
