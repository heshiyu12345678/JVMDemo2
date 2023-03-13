package com.atguigu.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/5
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 两数之和 {
    public static void main(String[] args) {
        int[] arr=new int[]{1,5,6,8};
        get2(arr,14);
    }
    public static int[] get(int[] nums,int target){//暴力法
        int[] arr=new int[2];
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-2; j++) {
                if(arr[i]+arr[j]==target){
                    arr[0]=i;
                    arr[1]=j;
                }
            }
        }
        return arr;
    }
    public static int[] get2(int[] nums,int target){//查表法
        int[] arr=new int[2];
        Map<Integer,Integer> map=new HashMap<>();
        int length = nums.length;
        for (int i = 0; i <= length - 1; i++) {
            int temp=target-nums[i];
            if(map.containsKey(temp)){
                arr[0]=i;
                arr[1]=map.get(temp);
            }else{
                map.put(nums[i],i);
            }
        }
        return arr;
    }
}
