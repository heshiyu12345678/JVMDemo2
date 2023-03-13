package com.atguigu.LeetCode;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/12
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 零钱兑换 {
    public static void main(String[] args) {

    }
    //方法一：记忆化搜索
    public int coinChange(int[] coins, int amount) {//coins银币面值，amount总量
        if (amount < 1) {
            return 0;
        }
        return coinChange(coins, amount, new int[amount]);
    }

    private int coinChange(int[] coins, int rem, int[] count) {
        if (rem < 0) {
            return -1;
        }
        if (rem == 0) {
            return 0;
        }
        if (count[rem - 1] != 0) {//先判断count中是否已经计算过了，直接取出返回
            return count[rem - 1];
        }
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {//每一次递归调用都会取最小的min。(从最底层开始计算）然后一层一层返回。
            int res = coinChange(coins, rem - coin, count);
            if (res >= 0 && res < min) {//每执行一次coinChange都要判断更新一下min的值。
                min = 1 + res;
            }
        }
        count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
        return count[rem - 1];
    }
}
