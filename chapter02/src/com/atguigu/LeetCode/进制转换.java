package com.atguigu.LeetCode;

import java.util.Scanner;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/5
 * @Description: com.atguigu
 * @version: 1.0
 */
public class 进制转换 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
       // test1(in);
        while(in.hasNextLine()){
            String s = in.nextLine();
            System.out.println(Integer.parseInt(s.substring(2),16));
        }
    }

    private static void test1(Scanner in) {
        while (in.hasNext()) { // 注意 while 处理多个 case
            String next = in.next();
            if(!next.startsWith("0x")){
                System.out.println("请输入一个16进制数");
            }else{
                int value=0;
                for (int i = next.length()-1; i > 1; i--) {
                    String c = ""+next.charAt(i);
                    int index = next.length() - 1 - i;
                    if("A".equals(c)||"a".equals(c)){
                        value+=10*Math.pow(16,index);
                    }else if("B".equals(c)||"b".equals(c)){
                        value+=11*Math.pow(16,index);
                    }else if("C".equals(c)||"c".equals(c)){
                        value+=12*Math.pow(16,index);
                    }else if("D".equals(c)||"d".equals(c)){
                        value+=13*Math.pow(16,index);
                    }else if("E".equals(c)||"e".equals(c)){
                        value+=14*Math.pow(16,index);
                    }else if("F".equals(c)||"f".equals(c)){
                        value+=15*Math.pow(16,index);
                    }else{
                        value+=Integer.valueOf(c)*Math.pow(16,index);
                    }
                }
                System.out.println(value);
            }
        }
    }
}
