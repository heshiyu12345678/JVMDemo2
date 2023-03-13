package com.atguigu.LeetCode;

import java.util.Scanner;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/6
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 整数与IP地址间的转换 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);//把ip当成256进制数来对待
        String str=sc.nextLine();
        String str1=sc.nextLine();
        System.out.println(convert(str));
        System.out.println(convert(str1));
        //System.out.println((255%256)==(255&(256-1)));//a%b==a&(b-1)前提b是2的n次方

    }
    public static String convert(String str){
        if(str.contains(".")){
            String[] strs=str.split("\\.");
            long result=0;
            for(int i=0;i<strs.length;i++){
                result=result<<8+Long.parseLong(strs[i]);
            }
            return ""+result;
        }else {
            long ipv4=Long.parseLong(str);
            String result="";
            for (int i=0;i<4;i++){
                result=(ipv4&255)+"."+result;//用位运算代替取模（留下最后一位）
                ipv4=ipv4>>8;//用位移运算代替除法a/b==a>>n(b是2的n次方）
            }
            return result.substring(0,result.length()-1);
        }
    }
}
