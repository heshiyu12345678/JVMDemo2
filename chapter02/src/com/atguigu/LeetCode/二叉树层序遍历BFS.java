package com.atguigu.LeetCode;

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
public class 二叉树层序遍历BFS {
    //题目要求的二叉树的 从上至下 打印（即按层打印），又称为二叉树的 广度优先搜索（BFS）。
    //BFS 通常借助 队列 的先入先出特性来实现。
    public static void main(String[] args) {

    }
    public int[] levelOrder(TreeNode root){
        if(root==null) return new int[0];
        int res[];
        List<Integer> list=new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        Integer[] arr = list.toArray(new Integer[list.size()]);
        res=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            res[i]=arr[i];
        }
        return res;
    }
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
