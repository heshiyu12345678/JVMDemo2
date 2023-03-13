package com.atguigu.LeetCode;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/5
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 子串重复判断 {
    public static void main(String[] args) {
        System.out.println(get("ab2346bdaldabab2"));
    }
    public static boolean get(String str){
        for (int i = 0; i < str.length()-2; i++) {
            String childstr=str.substring(i,i+3);
            if(str.substring(i+3).contains(childstr)){
                return true;
            }
        }
        return false;
    }
}
