package com.atguigu.LeetCode;

/**
 * @Auther: heshiyu
 * @Date: 2023/3/9
 * @Description: com.atguigu.LeetCode
 * @version: 1.0
 */
public class 最小覆盖子串 {
    //滑动窗口的思想：
    //用i,j表示滑动窗口的左边界和右边界，通过改变i,j来扩展和收缩滑动窗口，可以想象成一个窗口在字符串上游走，
    // 当这个窗口包含的元素满足条件，即包含字符串T的所有元素，记录下这个滑动窗口的长度j-i+1，这些长度中的最小值就是要求的结果。
    //步骤一
    //不断增加j使滑动窗口增大，直到窗口包含了T的所有元素
    //步骤二
    //不断增加i使滑动窗口缩小，因为是要求最小字串，所以将不必要的元素排除在外，使长度减小，
    // 直到碰到一个必须包含的元素，这个时候不能再扔了，再扔就不满足条件了，记录此时滑动窗口的长度，并保存最小值
    //步骤三
    //让i再增加一个位置，这个时候滑动窗口肯定不满足条件了，那么继续从步骤一开始执行，寻找新的满足条件的滑动窗口，
    // 如此反复，直到j超出了字符串S范围
    //我们用一个字典need来表示当前滑动窗口中需要的各元素的数量(map)
    //我们可以维护一个额外的变量needCnt来记录所需元素的总数量，当我们碰到一个所需元素c，不仅need[c]的数量减少1，同时needCnt也要减少1
    //可以开辟一个大小为64的数组，来存放数组中字母的频率(Frequency)。准确的说，
    //通过字母的ASCII码作为数组的索引，开辟空间的大小为26+6+26=58：26个大写字母，26个小写字母，
    //还有中间的6个非字母  A~Z[65~90]  非字母[91~96]  a~z[97~122]
    public static void main(String[] args) {

    }
    public static String get(String source,String target){
        int[] need=new int[64];//用数组来代表每个字符所需的个数，0代表不需要或者已经满足个数要求，负数表示不需要或者有重复的。
        for(int i=0;i<target.length();i++){
            char c = target.charAt(i);
            need[c]++;
        }
        int l=0;//左指针
        int r=0;//右指针
        int size=Integer.MAX_VALUE;//窗口大小
        int count=target.length();//所需元素的总数量
        int start=0;//最后结果的开始下标
        while(r<source.length()){//滑动窗口
            char c=source.charAt(r);
            if(need[c]>0){//需要字符c
                count--;
            }
            need[c]--;//把右边的字符加入窗口
            if(count==0){//窗口中已经包含所有字符
                while(l<r&&need[source.charAt(l)]<0){//去掉重复 或不需要的字符
                    need[source.charAt(l)]++;//总之就是去掉冗余的字符,缩小区间
                    l++;//指针右移
                }
                if(r-l+1<size){//更新有效区间的最小值
                    size=r-l+1;
                    start=l;
                }
                need[l]++;//l向右移动后窗口肯定不能满足了 重新开始循环（以寻找更短的）
                l++;
                count++;
            }
            r++;//右边界右移。
        }
        return size==Integer.MAX_VALUE ? "" : source.substring(start,start+size);
    }
}
