package com.xbfina.myJUC.assist.CyclicBarrier_;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Title: Test01
 * @Author 笑霸fianl
 * @Package com.xbfina.myJUC.assist.CyclicBarrier_
 * @Date 2023/4/5 9:38
 * @描述: 一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点(common barrier point)。
 *          在涉及一组固定大小的线程的程序中，这些线程必须不时地互相等待，此时   CyclicBarrier很有用。
 *          因为该 barrier在释放等待线程后可以重用，所以称它为循环的barrier。
 */
public class Test01 {

    private static int EMUN=7;
    public static void main(String[] args) {


        CyclicBarrier cyclicBarrier = new CyclicBarrier(EMUN, () -> {
            System.out.println("7课龙珠收集完成···· 招唤神龙");
        });

        for (int i = 1; i <=10; i++) {
            int finalI = i;
            new Thread(()->{

                try {

                    if(finalI >7){
                        Thread.sleep(50);
                    }
                    System.out.println(Thread.currentThread().getName()+"号龙珠收集了");
                    //cyclicBarrier等待7个线程后才执行
                    cyclicBarrier.await();


                } catch (Exception e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

    }
}
