package com.xbfina.myJUC.assist.semaphore_;

/**
 * @Title: test01
 * @Author 笑霸fianl
 * @Package com.xbfina.myJUC.assist.semaphore_
 * @Date 2023/4/5 9:55
 * @描述: 一个计数信号量。从概念上讲，信号量维护了一个许可集。如有必要，在许可可用前会阻塞每一个acuire()，
 *        然后再获取该许可。每个release()添加一个许可，从而可能释放一个正在阻塞的获取者。
 *        但是，不使用实际的许可对象，Senaphore只对可用许可的号码进行计数，并采取相应的行动。
 */


import java.util.Random;
import java.util.concurrent.Semaphore;
import java.util.stream.DoubleStream;

/**
 * 模拟6量汽车，停个v车位
 */
public class test01 {
   

    public static void main(String[] args) {
        //创建Semaphore类，并且设置许可数量
        Semaphore semaphore = new Semaphore(3);
        
        //模拟6量汽车
        for (int i = 1; i <= 6 ; i++) {
            new Thread(()->{
                try {
                    //抢占车位
                    semaphore.acquire();

                    System.out.println(Thread.currentThread().getName()+"抢占到车位");

                    //设置停车时间
                    Random random = new Random();
                    int i1 = random.nextInt(5);

                    System.out.println("停车时间"+i1);
                    Thread.sleep(i1*100);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally{
                    System.out.println(Thread.currentThread().getName()+"离开车位");
                    //离开车位
                    semaphore.release();

                }

            },String.valueOf(i)).start();
        }
    }


}
