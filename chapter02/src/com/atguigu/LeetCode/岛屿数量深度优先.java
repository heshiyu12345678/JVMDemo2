package com.atguigu.LeetCode;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/12
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 岛屿数量深度优先 {
    public static void main(String[] args) {
        //我们可以将二维网格看成一个无向图，竖直或水平相邻的 之间有边相连。
        //为了求出岛屿的数量，我们可以扫描整个二维网格。如果一个位置为1
        //则以其为起始节点开始进行深度优先搜索。在深度优先搜索的过程中，每个搜索到的都会被重新标记为0
        //最终岛屿的数量就是我们进行深度优先搜索的次数。
        //遍历整块大陆，横着竖着遍历都可以。
        //第一次碰到陆地的时候，就知道这是块岛屿了，所以将这块陆地放入探险队列，岛屿数量加一。
        //然后我们将这块岛屿的陆地探索完。每一次将这块陆地周围（上下左右）的陆地放入队列，然后将这块陆地标记为已探索（这里就直接置为'0'了）。
        //当探险队列为空时，表示这块岛屿的陆地全部被探索完了，我们继续寻找下一块陆地

    }
    void dfs(char[][] grid, int r, int c) {
        int nr = grid.length;//行数
        int nc = grid[0].length;//列数
        //r,c为当前坐标
        if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';//把是1的位置设置为0，表示已经走过的。
        dfs(grid, r - 1, c);//将该位置的上下左右四个方向上的1全部设置为1.
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;
        for (int r = 0; r < nr; ++r) {//遍历整块大陆
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    dfs(grid, r, c);
                }
            }
        }
        return num_islands;
    }
}
