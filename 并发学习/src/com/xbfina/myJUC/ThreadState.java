package com.xbfina.myJUC;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Title: ThreadState
 * @Author 笑霸fianl
 * @Package com.xbfina.myJUC
 * @Date 2023/5/13 9:36
 * @描述:
 */
public class ThreadState {

    /**
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

        ThreadState threadState = new ThreadState();
        Thread na = new Thread(() -> {

            synchronized (threadState){
                threadState.notify();
                try {
                    threadState.wait();
                    TimeUnit.SECONDS.sleep(1);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    threadState.notify();
                }
            }
            System.out.println(Thread.currentThread().getName() + "运行了");
        }, "na");

        System.out.println(na.getState());//NEW


        na.start();
        System.out.println(na.getState());//RUNNABLE

        synchronized (threadState){
            threadState.notify();
            try {
                threadState.wait();
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                threadState.notify();
            }
        }
        System.out.println(na.getState());//BLOCKED




//        public enum State {
//            /**
//             * Thread state for a thread which has not yet started.
//             */
//            NEW,
//
//            /**
//             * Thread state for a runnable thread.  A thread in the runnable
//             * state is executing in the Java virtual machine but it may
//             * be waiting for other resources from the operating system
//             * such as processor.
//             */
//            RUNNABLE,
//
//            /**
//             * Thread state for a thread blocked waiting for a monitor lock.
//             * A thread in the blocked state is waiting for a monitor lock
//             * to enter a synchronized block/method or
//             * reenter a synchronized block/method after calling
//             * {@link Object#wait() Object.wait}.
//             */
//            BLOCKED,
//
//            /**
//             * Thread state for a waiting thread.
//             * A thread is in the waiting state due to calling one of the
//             * following methods:
//             * <ul>
//             *   <li>{@link Object#wait() Object.wait} with no timeout</li>
//             *   <li>{@link #join() Thread.join} with no timeout</li>
//             *   <li>{@link LockSupport#park() LockSupport.park}</li>
//             * </ul>
//             *
//             * <p>A thread in the waiting state is waiting for another thread to
//             * perform a particular action.
//             *
//             * For example, a thread that has called <tt>Object.wait()</tt>
//             * on an object is waiting for another thread to call
//             * <tt>Object.notify()</tt> or <tt>Object.notifyAll()</tt> on
//             * that object. A thread that has called <tt>Thread.join()</tt>
//             * is waiting for a specified thread to terminate.
//             */
//            WAITING,
//
//            /**
//             * Thread state for a waiting thread with a specified waiting time.
//             * A thread is in the timed waiting state due to calling one of
//             * the following methods with a specified positive waiting time:
//             * <ul>
//             *   <li>{@link #sleep Thread.sleep}</li>
//             *   <li>{@link Object#wait(long) Object.wait} with timeout</li>
//             *   <li>{@link #join(long) Thread.join} with timeout</li>
//             *   <li>{@link LockSupport#parkNanos LockSupport.parkNanos}</li>
//             *   <li>{@link LockSupport#parkUntil LockSupport.parkUntil}</li>
//             * </ul>
//             */
//            TIMED_WAITING,
//
//            /**
//             * Thread state for a terminated thread.
//             * The thread has completed execution.
//             */
//            TERMINATED;
//        }
//
//



    }

}
