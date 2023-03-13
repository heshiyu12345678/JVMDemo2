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
public class 二叉树分层打印 {
    public static void main(String[] args) {

    }
    public static List<List<Integer>> levelOrder(TreeNode root){
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> list=new ArrayList<>();
        if(root!=null) queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            for(int i=queue.size();i>0;i--){
                TreeNode node = queue.poll();
                temp.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
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
