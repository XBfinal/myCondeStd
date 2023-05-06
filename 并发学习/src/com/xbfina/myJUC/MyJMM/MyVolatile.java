package com.xbfina.myJUC.MyJMM;

import java.util.concurrent.TimeUnit;

/**
 * @Title: MyVolatile
 * @Author 笑霸fianl
 * @Package com.xbfina.myJUC
 * @Date 2023/5/6 19:57
 * @描述:
 */
public class MyVolatile {

//    private static int num=0;
    private static volatile int num=0;  //volatile的可见性
    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            while (num==0){

            }

        },"1").start();

        TimeUnit.SECONDS.sleep(1);

        num=1;
        System.out.println("当前线程；"+Thread.currentThread().getName()+"\t num的值："+num);
    }
}
