package com.xbfina.myJUC;

import com.sun.corba.se.spi.orbutil.threadpool.WorkQueue;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Title: MyExecutors
 * @Author 笑霸fianl
 * @Package com.xbfina.myJUC
 * @Date 2023/5/3 19:19
 * @描述: 线程池
 */
public class MyExecutors {

    public static void main(String[] args) {


        System.out.println( Runtime.getRuntime().availableProcessors());
        //手动创建一个线程池
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                0,
                Runtime.getRuntime().availableProcessors(),
                3,//超时时间
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),//阻塞队列
                Executors.defaultThreadFactory(),//工厂一般不动
                new ThreadPoolExecutor.DiscardPolicy());

        for (int i = 0; i <10; i++) {
            threadPoolExecutor.execute(()->{
                System.out.println("当前线程："+Thread.currentThread().getName());
            });

        }

        //切记完毕后关闭线程池
        threadPoolExecutor.shutdown();
    }
}
