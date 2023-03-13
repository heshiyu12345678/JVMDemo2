package com.atguigu.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/11
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class tset1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m=Integer.valueOf(in.nextLine());
        int[][] nums=new int[m][];
        for(int i=0;i<m;i++){
            String temp=in.nextLine();
            String[] str=temp.split(",");
            nums[i]=new int[str.length];
            for(int j=0;j<str.length;j++){
                nums[i][j]=Integer.valueOf(str[j]);
            }
        }
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<m;i++){
            int[] a=nums[i];
            if(a.length==1){
                List<Integer> tem=new ArrayList<>();
                tem.add(a[0]);
                list.add(tem);
            }
        }
        System.out.println(list);
    }
}
