package com.atguigu.LeetCode;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/5
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 条台阶 {
    public static void main(String[] args) {
        System.out.println(get(10));
        System.out.println(get2(10));
        System.out.println(1000000008%1000000007);
        System.out.println(100000008%1000000007);
        System.out.println("1223456789".substring(3));
        System.out.println("1223456789".substring(3,6));
        System.out.println(Integer.MAX_VALUE);
    }
    public static int get(int n){
        if(n<2){
            return 1;
        }

        return get(n-1)+get(n-2);
    }
    public static int get2(int n){
        if(n<=1)return 1;
        int[] arr=new int[n+1];//数组的长度一定是n+1
        arr[0]=1;
        arr[1]=1;
        for(int i=2;i<=n;i++){
            arr[i]=(arr[i-1]+arr[i-2])%1000000007;//1,8个0,7取模，保证不会溢出。
        }
        return arr[n];
    }
}
