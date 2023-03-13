package com.atguigu.LeetCode;

import java.util.*;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/9
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 称砝码 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashSet<Integer> set=new HashSet<>();
        set.add(0);
        int n = sc.nextInt();
        int[] w=new int[n];
        int[] num=new int[n];
        for(int i=0;i<n;i++){
            w[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){
            num[i]=sc.nextInt();
        }
        for(int i=0;i<n;i++){//遍历砝码种类
            List<Integer> list=new ArrayList<>(set);//当前的所有重量集合。
            for(int j=1;j<=num[i];j++){//遍历每一种的个数
                for(int k=0;k<list.size();k++){//当前种类的砝码数循环去和上一个种类的砝码的重量集合循环相加。
                    set.add(list.get(k)+w[i]*j);
                }
            }
        }
        System.out.println(set.size());
    }
}
