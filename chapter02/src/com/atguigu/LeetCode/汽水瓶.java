package com.atguigu.LeetCode;

import java.util.Scanner;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/11
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 汽水瓶 {

    //三个空汽水瓶可以换一瓶汽水，允许向老板借空汽水瓶（但是必须要归还）。
    //小张手上有n个空汽水瓶，她想知道自己最多可以喝到多少瓶汽水。
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别

        while(in.hasNext()){
            int a=in.nextInt();
            System.out.println(get(a));
        }
    }
    public static int get(int nums){
        int total=0;
        if(nums<2){
            return 0;
        }
        if(nums==2){
            return 1;
        }
        total+=nums/3+get(nums%3+nums/3);
        return total;
    }
}
