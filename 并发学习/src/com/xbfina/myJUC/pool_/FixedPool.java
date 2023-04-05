package com.xbfina.myJUC.pool_;

import org.testng.annotations.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Title: FixedPool
 * @Author 笑霸fianl
 * @Package com.xbfina.myJUC.pool_
 * @Date 2023/4/5 14:08
 * @描述:
 */
public class FixedPool {
    public static void main(String[] args) {
        //创建线程池  5个(一池多线程)
        ExecutorService threadPool1 = Executors.newFixedThreadPool(5);

        //十个顾客
        try{
            for (int i = 1; i <= 10 ; i++) {
                int finalI = i;
                threadPool1.execute(()->{
                    System.out.println(Thread.currentThread()+"当前编号："+ finalI);
                });
            }
        }finally {
            //关闭
            threadPool1.shutdown();
        }
    }

    @Test
    public void test01(){
        //创建线程池 (一池一线程)、
        ExecutorService threadPool2 = Executors.newSingleThreadExecutor();

        //十个顾客
        try{
            for (int i = 1; i <= 10 ; i++) {
                int finalI = i;
                threadPool2.execute(()->{
                    System.out.println(Thread.currentThread()+"当前编号："+ finalI);

                });
            }
        }finally {
            //关闭
            threadPool2.shutdown();
        }

    }

    @Test
    public void test02(){
        //创建线程池 (一池可扩容线 程 )、
        ExecutorService threadPool3 = Executors.newCachedThreadPool();

        //十个顾客
        try{
            for (int i = 1; i <= 30 ; i++) {
                int finalI = i;
                threadPool3.execute(()->{
                    System.out.println(Thread.currentThread()+"当前编号："+ finalI);
                });
            }
        }finally {
            //关闭
            threadPool3.shutdown();
        }

    }
}
