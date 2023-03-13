package com.atguigu.LeetCode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/12
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 岛屿数量广度优先 {
    public static void main(String[] args) {

    }
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();//记录邻居的坐标
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {//遍历队列中的所有邻居节点。
                        int id = neighbors.remove();
                        int row = id / nc;//通过队列的数字计算出当前位置的坐标
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {//上边有邻居且是陆地将其加入到队列中，并将其位置设置为0
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {//下边有邻居且是陆地将其加入到队列中，并将其位置设置为0
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {//左边有邻居且是陆地将其加入到队列中，并将其位置设置为0
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {//有边有邻居且是陆地将其加入到队列中，并将其位置设置为0
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }
}

