package com.atguigu.LeetCode;

import java.util.Scanner;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/6
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class ip与整数 {
    public static String longToIp(long ipLong){
        StringBuilder sb = new StringBuilder();
        sb.append(ipLong>>>24);sb.append(".");
        sb.append(String.valueOf((ipLong&0x00FFFFFF)>>>16));sb.append(".");
        sb.append(String.valueOf((ipLong&0x0000FFFF)>>>8));sb.append(".");
        sb.append(String.valueOf(ipLong&0x000000FF));
        return sb.toString();
    }
    public static long ipToLong(String ipString){
        long result = 0;
        java.util.StringTokenizer token = new java.util.StringTokenizer(ipString,".");
        result += Long.parseLong(token.nextToken())<<24;
        result += Long.parseLong(token.nextToken())<<16;
        result += Long.parseLong(token.nextToken())<<8;
        result += Long.parseLong(token.nextToken());
        return result;
    }
    public static void main(String[] args0) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String string1 =sc.next();
            long lg = sc.nextLong();
            if(!string1.equals("")&&lg>=0){
                System.out.println(ipToLong(string1));
                System.out.println(longToIp(lg));
            }

        }
    }
}
