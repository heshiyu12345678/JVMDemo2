package com.atguigu.LeetCode;

import sun.reflect.generics.tree.Tree;

import java.util.*;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/7
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 成绩排序 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int perp=Integer.valueOf(in.nextLine());
        int flag=Integer.valueOf(in.nextLine());
        Map<Integer,String> map=new HashMap<>();//
        Integer[] arr=new Integer[perp];
        for(int i=0;i<perp;i++){
            String temp=in.nextLine();
            String[] split=temp.split(" ");
            int num=Integer.valueOf(split[1]);
            arr[i]=num;
            if(map.containsKey(num)){
                map.put(num,map.get(num)+","+split[0]);
            }else{
                map.put(num,split[0]);
            }
        }
        if(flag==1){
            Arrays.sort(arr);
        }else{
            Arrays.sort(arr,Collections.reverseOrder());//对数组进行降序排列
        }
        for (int i = 0; i < arr.length;) {
            String s = map.get(arr[i]);
            if(s.contains(",")){
                String[] s1 = s.split(",");
                for (int j = 0; j < s1.length; j++) {
                    System.out.println(s1[j]+" "+arr[i]);
                }
                i+=s1.length;
            }else{
                System.out.println(s+" "+arr[i]);
                i++;
            }
        }
    }
}
