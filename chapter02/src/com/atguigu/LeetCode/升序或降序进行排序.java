package com.atguigu.LeetCode;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/6
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 升序或降序进行排序 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int num = sc.nextInt();
            int[] arr = new int[num];
            for(int i = 0; i < num; i++){
                arr[i] = sc.nextInt();
            }
            int flag = sc.nextInt();
            get(num, arr, flag);
        }

    }
    public static String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }

    private static void get(int num,  int[] arrs,int falg) {
        if(falg ==0){
            Arrays.sort(arrs);
            for(int i = 0; i< num; i++){
                System.out.println(arrs[i]);
            }
        }
        if(falg ==1){
            Arrays.sort(arrs);
            for(int i = num -1; i>=0; i--){
                System.out.println(arrs[i]);
            }
        }
    }
}
