package com.xbfina.jichu;

import org.testng.annotations.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title: StringStd
 * @Author 笑霸fianl
 * @Package com.xbfina.jichu
 * @Date 2023/8/11 13:04
 * @描述:
 */
public class StringStd {
    public static void main(String[] args) {
        StringBuffer stringBuffer = new StringBuffer(1);
        stringBuffer.append("你好");
        stringBuffer.append("hello");
        System.out.println(stringBuffer);
    }


    @Test
    public void printDbThread_1(){
        Object o = new Object();

        new Thread( () ->{
           synchronized (o){
               for (int i = 1; i <= 100; i++) {
                   if(i % 2 ==0){
                           System.out.println(i+"当前线程："+Thread.currentThread().getName());
                           o.notify();
                   }else{
                       try {
                           o.wait();
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                   }

               }
           }
        },"线程1").start();

        new Thread( () ->{
            synchronized (o){
                for (int i = 1; i <= 100; i++) {
                    if(i % 2 !=0){
                        System.out.println(i+"当前线程："+Thread.currentThread().getName());
                        o.notify();
                    }else{
                        try {
                            o.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            }
        },"线程2").start();

    }


    @Test
    public void printDbThread_2(){
        ReentrantLock lock = new ReentrantLock();
        new Thread( () ->{
            lock.lock();
                for (int i = 1; i <= 100; i++) {
                    if(i % 2 ==0){
                        System.out.println(i+"当前线程："+Thread.currentThread().getName());
                        lock.notify();
                    }else{
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }
            lock.unlock();
        },"线程1").start();

    }
}
