package com.atguigu.LeetCode;

import java.util.*;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/6
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 删除字符串中出现次数最少的字符 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<str.length();i++){
            char ch=str.charAt(i);
            int num=map.getOrDefault(ch,0);
            map.put(ch,num+1);
        }
        Collection<Integer> collection= map.values();
        Integer min=Collections.min(collection);
        for(Character cha:map.keySet()){
            if(map.get(cha)==min){
                str=str.replaceAll(String.valueOf(cha),"");
            }
        }
        System.out.println(str);
    }
}
