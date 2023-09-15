package com.xbfina.myJUC.syn_;

/**
 * @Title: lockEscalation
 * @Author 笑霸fianl
 * @Package com.xbfina.myJUC.syn_
 * @Date 2023/8/9 8:05
 * @描述: 锁升级
 */
public class lockEscalation {
    public static void main(String[] args) {
        Object lockObject = new Object();
        new Thread( ()->{
            synchronized (lockObject){
                System.out.println(ClassLoader.getSystemClassLoader());
            }
        },"T1").start();
    }
}
