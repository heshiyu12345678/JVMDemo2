package com.atguigu.LeetCode;

import java.util.*;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/5
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 明明的随机数 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int i = scanner.nextInt();
        generate(i);
    }
    public static void generate(int n){
        TreeSet<Integer> treeSet=new TreeSet<>();

        for (int i = 1; i <= n; i++) {
            int temp = new Random().nextInt(500);
            treeSet.add(temp);
            System.out.println(temp);
        }
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
