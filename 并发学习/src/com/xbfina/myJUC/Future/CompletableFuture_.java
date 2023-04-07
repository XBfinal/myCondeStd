package com.xbfina.myJUC.Future;

import org.testng.annotations.Test;

import java.util.concurrent.*;

/**
 * @Title:   CompletableFuture_
 * @Author   笑霸fianl
 * @Package  com.xbfina.myJUC.Future
 * @Date     2023/4/7 17:50
 * @描述:
 */
public class CompletableFuture_ {
    public static void main(String[] args) {

//        不推荐此方法创建对象
//        CompletableFuture completableFuture = new CompletableFuture();


    }


    /**
     * 方法一   runAsync无返回值
     *
     *             CompletableFuture.runAsync(Runnable)
     *          或
     *              CompletableFuture.runAsync(Runnable ,线程池 )
     *
     */
    @Test
    public void test01() {
        ExecutorService threadPool = Executors.newFixedThreadPool(3);


        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName());
            }
        },threadPool);

//        System.out.println(voidCompletableFuture.get());//无返回值
        threadPool.shutdown();

    }


    /**
     *   方法二  有返回值 supplyAsync()
     *
     *
     *             CompletableFuture.supplyAsync(Supplier)
     *          或
     *              CompletableFuture.supplyAsync(Supplier ,线程池 )
     *
     */
    @Test
    public void test02() throws ExecutionException, InterruptedException {

        ExecutorService threadPool2 = Executors.newFixedThreadPool(3);

        CompletableFuture.supplyAsync(() -> {
            int sum = 0;
            for (int i = 0; i <= 10; i++) {
                sum+=i;
            }
            System.out.println(Thread.currentThread().getName());
            return sum;
        },threadPool2).whenComplete((v,e)->{
                // v是 返回值   e是异常
            if(e==null){
                //没有异常
                System.out.println(v+" 是返回值");
            }
        }).exceptionally(e->{
            System.out.println(e);
            return null;
        });

//        System.out.println(integerCompletableFuture.get());也会阻塞


        threadPool2.shutdown();
        Thread.sleep(500);
        System.out.println("主线程结束");



    }
}
