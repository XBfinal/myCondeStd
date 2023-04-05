package com.xbfina.myJUC.assist.CountDownLatch_;

import java.util.concurrent.CountDownLatch;

/**
 * @Title: Test01
 * @Author 笑霸fianl
 * @Package com.xbfina.myJUC.assist.CountDownLatch_
 * @Date 2023/4/5 9:25
 * @描述: 减少计数辅助类
 */
public class Test01 {
    public static void main(String[] args) throws InterruptedException {


        CountDownLatch count = new CountDownLatch(6);//初始值设置为6
        for(int i = 1 ; i <= 6;i++){

            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"号同学离开教室");

                count.countDown();//执行一次 初始值减一
            },String.valueOf(i)).start();
        }


        count.await();//先阻塞主线程  等待初始值为0  就唤醒主线程

        System.out.println("锁门");

    }
}
