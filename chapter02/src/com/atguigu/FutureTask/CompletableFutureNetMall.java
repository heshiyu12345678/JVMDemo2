package com.atguigu.FutureTask;

import jdk.nashorn.internal.objects.annotations.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Auther: heshiyu
 * @Date: 2023/2/24
 * @Description: com.atguigu.FutureTask
 * @version: 1.0
 */
public class CompletableFutureNetMall {
    static List<NetMall1> list= Arrays.asList(
            new NetMall1("jd"),
            new NetMall1("dangdang"),
            new NetMall1("taobao")
    );
    public static List<String> getPrice(List<NetMall1> list,String productName){
        return list.stream()
                .map(netMall ->
                        String.format(productName+"in %s price is %.2f",
                                netMall.getNetMallName(),
                                netMall.calcPrice(productName)))
                .collect(Collectors.toList());
    }
    public static List<String> getPriceByCompletableFuture(List<NetMall1> list,String productName){
        return list.stream()
                .map(netMall -> CompletableFuture.supplyAsync(()->String.format(productName+"in %s price is %.2f",
                        netMall.getNetMallName(),
                        netMall.calcPrice(productName)))
                ).collect(Collectors.toList()).stream().map(completableFuture-> completableFuture.join()).collect(Collectors.toList());
    }
    public static void main(String[] args) {
        long startTime=System.currentTimeMillis();
        List<String> mysql = getPriceByCompletableFuture(list, "mysql");
        for(String element:mysql){
            System.out.println(element);
        }
        long endTime=System.currentTimeMillis();
        System.out.println("-----costTime:"+(endTime-startTime)+"毫秒");
    }
}

class NetMall1{
    private String netMallName;

    public NetMall1(String netMallName){
        this.netMallName=netMallName;
    }
    public double calcPrice(String productName){
        try {
            TimeUnit.MILLISECONDS.sleep(500);} catch(InterruptedException e){e.printStackTrace();}
        return ThreadLocalRandom.current().nextDouble()*2+productName.charAt(0);
    }

    public String getNetMallName() {
        return netMallName;
    }

    public void setNetMallName(String netMallName) {
        this.netMallName = netMallName;
    }
}