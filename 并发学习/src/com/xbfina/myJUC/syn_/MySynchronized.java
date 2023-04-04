package com.xbfina.myJUC.syn_;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title: MySynchronized
 * @Author 笑霸fianl
 * @Package com.xbfina.myJUC.syn_
 * @Date 2023/4/4 10:12
 * @描述: 线程之间的通信
 */
public class MySynchronized {

    public static void main(String[] args) {
        Ticket lTicket = new Ticket();

        new Thread(()->{
            Thread.currentThread().setName("AA");
            for(int i = 0 ;i<60;i++){
                lTicket.sale();
            }
        }).start();

        new Thread(()->{
            Thread.currentThread().setName("BB");
            for(int i = 0 ;i<60;i++){
                lTicket.sale();
            }
        }).start();
    }

}

//创建资源类
class Ticket {
    //资源
    private int nums = 50;


    //消费资源的方法
    public synchronized void sale()  { //synchronized 非静态方法中 同步监视器 是this
        if (this.nums <= 0) {
            return;
        }

        try {
            notify();
            Thread.sleep(50);
            if (this.nums > 0) {

                System.out.println("当前资源数量为：" + this.nums + "当前线程名：" + Thread.currentThread().getName());
                this.nums--;
                wait();


            }
        } catch (Exception e) {
            e.printStackTrace();
        }




    }

}
