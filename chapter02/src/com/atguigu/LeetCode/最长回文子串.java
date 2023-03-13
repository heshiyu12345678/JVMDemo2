package com.atguigu.LeetCode;


import java.util.Scanner;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/9
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 最长回文子串 {//双指针遍历查找最长回文子串
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        int max=0;
        for(int i=0;i<s.length();i++){
            for (int j=s.length();j>i;j--){//一前一后双指针
                if(get(s.substring(i,j))){
                    max=Math.max(max,j-i);
                    break;
                }
            }
        }
        System.out.println(max);
    }
    public static boolean get(String str){
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
