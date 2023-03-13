package com.atguigu.LeetCode;


import sun.awt.image.ImageWatched;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/10
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 二叉树分层交叉打印 {
    public static void main(String[] args) {
        //请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，
        // 第三行再按照从左到右的顺序打印，其他行以此类推。
    }

    public static List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> list=new ArrayList<>();
        Queue<TreeNode> queue= new LinkedList<>();
        if(root!=null)queue.add(root);
        while(!queue.isEmpty()){
            LinkedList<Integer> temp=new LinkedList<>();//双端队列体现顺序
            for(int i= queue.size();i>0;i--){//i的值只会初始化一次。直到当前循环次数走完
                TreeNode poll = queue.poll();
                if((list.size()&1)==0) {
                    temp.addFirst(poll.val);
                } else{
                    temp.addLast(poll.val);
                }
                if(poll.right!=null)queue.add(poll.right);
                if(poll.left!=null)queue.add(poll.left);
            }
            list.add(temp);
        }
        return list;
    }
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
