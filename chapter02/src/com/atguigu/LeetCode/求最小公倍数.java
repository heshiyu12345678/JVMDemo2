package com.atguigu.LeetCode;

import java.util.Scanner;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/9
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 求最小公倍数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a=in.nextInt();
        int b=in.nextInt();
        //最小公倍数=a*b/最大公约数
        System.out.println(a*b/get(a,b));
    }

    public  static int get(int a,int b){//求最大公约数
        int x=Math.max(a,b);
        int y=Math.min(a,b);
        while (y>0){
            int mod=x%y;
            if(y>mod){
                x=y;
                y=mod;
            }else{
                x=mod;
            }
        }
        return x;
    }
}
