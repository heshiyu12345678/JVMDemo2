package com.atguigu.LeetCode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/8
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class test {
    public static void main(String[] args) {
        combine(4,2);
    }

    public static List<List<Integer>> combine(int n,int k){
        List<List<Integer>> res=new ArrayList<>();
        if(n<=0||n<k){
            return res;
        }
        Deque<Integer> path=new ArrayDeque<>();
        dfs(n,k,1,path,res);
        return res;
    }
    public static void dfs(int n, int k, int begin, Deque<Integer> path,List<List<Integer>> res){
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i <=n; i++) {
            path.addLast(i);
            dfs(n,k,begin+1,path,res);
            path.removeLast();
        }
    }
}
