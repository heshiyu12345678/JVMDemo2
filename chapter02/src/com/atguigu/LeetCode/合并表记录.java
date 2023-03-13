package com.atguigu.LeetCode;

import java.util.*;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/6
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 合并表记录 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Integer,Integer> map=new HashMap<>();
        int len = in.nextInt();
        TreeSet<Integer> set=new TreeSet<>();
        for(int i=0;i<len;i++){
            int key=in.nextInt();
            set.add(key);
            int value=in.nextInt();
            int value1=map.getOrDefault(key,0);
            map.put(key,value+value1);//key相同，value相加
        }
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            System.out.print(""+next+" "+map.get(next)+"\n");
        }
    }
}
