package com.atguigu.LeetCode;

import java.util.Scanner;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/6
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 坐标移动 {
    public static void main(String[] args) {
        int x=0;
        int y=0;
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(";");
        for (String s : split) {
            if(!s.matches("[ASDW][0-9]{1,2}")){
                continue;
            }
            int value=Integer.valueOf(s.substring(1));
            switch(s.charAt(0)){
                case 'A':
                    x-=value;
                    break;
                case 'D':
                    x+=value;
                    break;
                case 'S':
                    y-=value;
                    break;
                case 'W':
                    y+=value;
                    break;
            }
        }
        System.out.println(x+","+y);
    }
}
