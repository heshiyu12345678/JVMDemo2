package com.atguigu.LeetCode;

import javafx.geometry.Pos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/11
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 迷宫问题 {
    public static void main(String[] args) {
        //// 题目已经提示了 【迷宫只有一条通道】，则直接使用 DFS 找路径就行了，如不有多条路径找最短考虑使用 BFS
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int n = in.nextInt();
            int m = in.nextInt();
            // 构造迷宫
            int[][] map = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = in.nextInt();
                }
            }

            // 路径存储的数组
            List<Pos> path = new ArrayList<>();
            // DFS 搜索路径
            dfs(map, 0, 0, path);
            // 输出
            for (Pos p : path) {
                System.out.println("(" + p.x + "," + p.y + ")");
            }
        }
    }

    private static boolean dfs(int[][] map, int x, int y, List<Pos> path) {//返回值标记是否找到可通行的路劲。
        path.add(new Pos(x,y));
        map[x][y]=1;//表示当前位置已经走过，不能再走了此路不通(只有等于0才会进入这个方法）
        //结束
        if(x==map.length-1&&y==map[0].length-1){
            return false;
        }
        //向下能走时
        if(x+1<map.length&&map[x+1][y]==0){
            if(dfs(map,x+1,y,path)){
                return true;
            }
        }
        //向右走
        if(y+1<map[0].length&&map[x][y+1]==0){
            if(dfs(map,x,y+1,path)){
                return true;
            }
        }
        //向上走
        if(x-1>-1&&map[x-1][y]==0){
            if(dfs(map,x-1,y,path)){
                return true;
            }
        }
        //向左走
        if(y-1>-1&&map[x][y-1]==0){
            if(dfs(map,x,y-1,path)){
                return true;
            }
        }


        // 回溯
        path.remove(path.size() - 1);
        map[x][y] = 0;//再四个方向都走不通的时候，把当前位置
        return false;
    }
    // 简单的位置类
    public static class Pos {
        int x;
        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
