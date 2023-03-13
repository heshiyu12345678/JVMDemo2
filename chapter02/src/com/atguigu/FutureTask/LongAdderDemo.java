package com.atguigu.FutureTask;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Auther: heshiyu
 * @Date: 2023/2/27
 * @Description: com.atguigu.FutureTask
 * @version: 1.0
 */
public class LongAdderDemo {
    public static void main(String[] args) {
        LongAdder longAdder=new LongAdder();
        longAdder.increment();
        longAdder.increment();
        longAdder.increment();
        longAdder.decrement();
        longAdder.decrement();
        longAdder.decrement();
        longAdder.decrement();
        System.out.println(longAdder.sum());
        LongAccumulator longAccumulator = new LongAccumulator((x,y)->x+y,0);
        longAccumulator.accumulate(1);
        longAccumulator.accumulate(4);
        System.out.println(longAccumulator.get());
    }
}
