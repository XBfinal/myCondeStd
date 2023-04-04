package com.xbfina.myJUC.thread_;

/**
 * @Title: MyThread
 * @Author 笑霸fianl
 * @Package com.xbfina.myJUC.thread_
 * @Date 2023/4/2 18:31
 * @描述:
 */


/**
 * ==============方式一 继承 Thread类
 * 1.创建一个继承于 Thread的子类
 * 重写 run（）方法
 * 创建对象  带哦用start（）
 */
public class MyThread extends Thread{

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
