package com.atguigu.LeetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/9
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 素数伴侣 {//素数一定是偶数加奇数（任何一个数与1短路与运算等1则为奇数，为0则为偶数，n&1）
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[] temp=new int[n];
        for(int i=0;i<n;i++){
            temp[i]=in.nextInt();
        }
        List<Integer> events=new ArrayList<>();
        List<Integer> odds=new ArrayList<>();
        for(int i=0;i<n;i++){
            if((temp[i]&1)==1){
                odds.add(temp[i]);
            }else{
                events.add(temp[i]);
            }
        }
    }
}
