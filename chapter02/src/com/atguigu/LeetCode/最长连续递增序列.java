package com.atguigu.LeetCode;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/9
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 最长连续递增序列 {
    public static void main(String[] args) {
        int[] nums=new int[]{1,2,3,4,6,7,8,5};
        System.out.println(findLengthOfLCIS(nums));
    }
    public static int findLengthOfLCIS(int[] nums) {
        int left=0;
        int right=0;
        int result=0;
        for (right = 1; right < nums.length; right++) {
            if (nums[right - 1] >= nums[right]) {
                result = Math.max(result, right - left);
                left = right;//左指针只在右指针的值不连续递增时移动。
            }
        }
        return Math.max(result,right-left);
    }
}
