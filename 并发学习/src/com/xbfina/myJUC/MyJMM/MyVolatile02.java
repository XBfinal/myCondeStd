package com.xbfina.myJUC.MyJMM;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Title: MyVolatile02
 * @Author 笑霸fianl
 * @Package com.xbfina.myJUC.MyJMM
 * @Date 2023/5/6 20:33
 * @描述: 验证 volatile 不保证原子性
 */
public class MyVolatile02 {


//    private static volatile int num=0;  //volatile 不保证原子性
private static volatile AtomicInteger num=new AtomicInteger(0);//原子类的int

    public  static void add(){
//        num++;//不是原子性
//        num.incrementAndGet(); //以原子性的方法递增当前值  unsafe.getAndAddInt(this, valueOffset, 1) + 1;
        num.getAndIncrement();//以原子性的方法递增当前值 unsafe.getAndAddInt(this, valueOffset, 1);

    }

    public static void main(String[] args) {


        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();

        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }


        System.out.println(num);
    }
}
