package com.xbfina.myJUC.runable_;

/**
 * @Title: MyRunable
 * @Author 笑霸fianl
 * @Package com.xbfina.myJUC.runable_
 * @Date 2023/4/2 18:51
 * @描述:
 */
public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i=2;i<=200; i++){
            if(i%2==0){
                System.out.println(i+"---"+Thread.currentThread().getName());
            }
        }
        System.out.println("子线程结束"+Thread.currentThread().getName());
    }
}
