package com.xbfina.myJUC.ThreadLocal_;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Title: Demo
 * @Author 笑霸fianl
 * @Package com.xbfina.myJUC.ThreadLocal_
 * @Date 2023/4/10 16:14
 * @描述:
 */
public class Demo {


    public static void main(String[] args) {

        ThreadLocal<Integer> integerThreadLocal = ThreadLocal.withInitial(() -> 0);


        new Thread(()->{

            for(int i = 0 ;i < 10;i++){
                integerThreadLocal.set(integerThreadLocal.get()+1);
            }

            System.out.println(Thread.currentThread().getName()+":"+integerThreadLocal.get());
        },"t1").start();

        new Thread(()->{

            for(int i = 0 ;i < 20;i++){
                integerThreadLocal.set(integerThreadLocal.get()+1);
            }
            System.out.println(Thread.currentThread().getName()+":"+integerThreadLocal.get());
        },"t2").start();



        integerThreadLocal.remove();
    }
}
