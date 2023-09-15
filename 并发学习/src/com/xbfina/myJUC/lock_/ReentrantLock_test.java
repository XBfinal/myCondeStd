package com.xbfina.myJUC.lock_;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Title: ReentrantLock_test
 * @Author 笑霸fianl
 * @Package com.xbfina.myJUC.lock_
 * @Date 2023/8/27 16:04
 * @描述:
 */
public class ReentrantLock_test {

    String i;
    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        lock.lock();
        try{

        }catch (Exception e){
            lock.unlock();
        }
    }
}
