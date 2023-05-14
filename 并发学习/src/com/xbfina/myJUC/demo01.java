                                                                                            package com.xbfina.myJUC;

import com.xbfina.myJUC.runable_.MyRunnable;
import com.xbfina.myJUC.thread_.MyThread;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

                                                                                            /**
 * @Title: myThread
 * @Author 笑霸fianl
 * @Package com.xbfina.myJUC
 * @Date 2023/4/2 18:21
 * @描述: 继承Thread
 */
public class demo01 {



    /**
     * 测试Thread方式创建新线程
     * @throws InterruptedException
     */
    @Test
    void ThreadText() throws InterruptedException {
        MyThread myThread = new MyThread();

        //start() 作用：开启新线程 在执行run方法
        myThread.start();
//      myThread.run();

        for (int i=2;i<=200; i++){
            if(i%2==0){
                System.out.println(i+"---"+Thread.currentThread().getName());
            }
        }

        System.out.println("主线程结束"+Thread.currentThread().getName());

        /**
         * 1.能否直接调用myThread.run()实现分线程？
         * Q:不能！这样能执行但是没有开启新线程
         * 子线程结束 main
         * 主线程结束 main
         *
         * 2.同一个对象只能调一次start方法
         */
    }



    @Test
    void RunnableText(){
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

    }

    @Test
    void ThreadText2(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=2;i<=200; i++){
                    if(i%2==0){
                        System.out.println(i+"---"+Thread.currentThread().getName());
                    }
                }
                System.out.println("子线程结束"+Thread.currentThread().getName());
            }
        }).start();
    }
    /**
     * lamada表达式
     */
    @Test
    void ThreadText3(){
        new Thread(()->{
            for (int i=2;i<=200; i++){
                if(i%2==0){
                    System.out.println(i+"---"+Thread.currentThread().getName());
                }
            }
            System.out.println("子线程结束"+Thread.currentThread().getName());
        },"aa").start();


    }


    @Test
    void ThreadText4(){
        List<Integer> list =new ArrayList();
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        System.out.println(list.stream().reduce(0, Integer::sum));


    }
    
    @Test
    void CpuCore(){
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);

        //
        Runtime runtime = Runtime.getRuntime();
        Runtime runtime2 = Runtime.getRuntime();
        System.out.println(runtime==runtime2);
    }



}

