package com.xbfina.myJUC.pool_;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Title: MyThreadPoolllllll
 * @Author 笑霸fianl
 * @Package com.xbfina.myJUC.pool_
 * @Date 2023/4/5 14:44
 * @描述: 自定义线程池
 */
public class MyThreadPool {
    public MyThreadPool(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,
                5,
                3L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(4),
                new ThreadPoolExecutor.AbortPolicy());
    }
}
