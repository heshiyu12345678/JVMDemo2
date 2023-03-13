package com.atguigu.LeetCode;

import java.util.*;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/7
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 查找兄弟单词 {
    //定义一个单词的“兄弟单词”为：交换该单词字母顺序（注：可以交换任意次），而不添加、删除、修改原有的字母就能生成的单词。
    //兄弟单词要求和原来的单词不同。例如： ab 和 ba 是兄弟单词。 ab 和 ab 则不是兄弟单词。
    //现在给定你 n 个单词，另外再给你一个单词 x ，让你寻找 x 的兄弟单词里，按字典序排列后的第 k 个单词是什么？
    //注意：字典中可能有重复单词
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        String[] s1 = s.split(" ");
        int num=Integer.valueOf(s1[0]);
        int end=Integer.valueOf(s1[s1.length-1]);
        String tmp=s1[s1.length-2];
        List<String> list=new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            if(isBrother(tmp,s1[i])){
                list.add(s1[i]);
            }
        }
        System.out.println(list.size());
        if(list.size()>=end){
            Collections.sort(list);
            System.out.println(list.get(end-1));
        }
    }
    public static boolean isBrother(String str1,String str2){
        if(str1.length()!=str2.length()||str1.equals(str2)){
            return false;
        }
        char[] s1=str1.toCharArray();
        char[] s2=str2.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        return new String(s1).equals(new String(s2));
    }
}
