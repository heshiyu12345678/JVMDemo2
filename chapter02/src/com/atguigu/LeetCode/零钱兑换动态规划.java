package com.atguigu.LeetCode;

import java.util.Arrays;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/12
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 零钱兑换动态规划 {
    public static void main(String[] args) {

    }
    public static int coinChange(int[] coins,int amount){
        int max = amount + 1;
        int[] dp = new int[amount + 1];//状态定义:dp[j]为凑满容量为j的背包所需最少物品数
        Arrays.fill(dp, max);//将dp数组的所有下标出设置为amount+1比可能的最大值amount还要大。
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    //可以将dp数组初始化为一个很大的数​，每次更新时将更新值和旧值进行比较，
                    // 将dp[i]更新为两者中的较小的那个数，这样不需要分两种情况，直接​min(dp[i-coins[j]]+1, dp[i])。
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
