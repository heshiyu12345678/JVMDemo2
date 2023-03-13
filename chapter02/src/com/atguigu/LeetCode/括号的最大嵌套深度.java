package com.atguigu.LeetCode;

import java.util.Scanner;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/7
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 括号的最大嵌套深度 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        System.out.println(get(s));
    }
    public static int get(String str){
        int max=0;
        int now=0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if("(".equals(String.valueOf(chars[i]))){
                now++;
                if(now>max){
                    max++;
                }
            }
            if(")".equals(String.valueOf(chars[i]))){
                now--;
            }
        }
        return max;
    }
}
