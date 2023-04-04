package com.xbfina.myJUC.lock_;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title: MyLock
 * @Author 笑霸fianl
 * @Package com.xbfina.myJUC.lock_
 * @Date 2023/4/4 9:33
 * @描述:
 */
public class MyLock {
    public static void main(String[] args) {

        LTicket lTicket = new LTicket();

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
class LTicket{
    //资源
    private int nums = 50;

    //创建可重入锁
    private final ReentrantLock lock  = new ReentrantLock();
     Condition cd =  lock.newCondition();

    //消费资源的方法
    public void sale() {
        if(this.nums <= 0){
            return;
        }

        try{
            Thread.sleep(50);
        }catch (Exception e){
            e.printStackTrace();
        }


        try{
            lock.lock();
            if(this.nums > 0){

                System.out.println("当前资源数量为："+this.nums+"当前线程名："+Thread.currentThread().getName());
                this.nums--;

            }
        }finally {

            lock.unlock();
        }


    }

}
