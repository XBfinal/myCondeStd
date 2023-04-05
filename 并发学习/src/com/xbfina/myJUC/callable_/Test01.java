package com.xbfina.myJUC.callable_;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Title: Test01
 * @Author 笑霸fianl
 * @Package com.xbfina.myJUC.callable_
 * @Date 2023/4/5 8:53
 * @描述:
 */

class myCallable1 implements Callable{
    @Override
    public Object call() throws Exception {
        return 200;
    }
}

class myCallable2 implements Callable<String>{
    @Override
    public String call() throws Exception {
        return "创建成功";
    }
}
public class Test01 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        FutureTask<String> task = new FutureTask<>(new myCallable2());

        FutureTask<String> task = new FutureTask<>(() -> {
            Thread.sleep(1000);
            return " 子线程 ";
        });

        new Thread(task).start();
        //得到线程中返回的数据  会阻塞主线程 这个方法只会计算一次  第二次会直接返回结果
        String s = task.get();
        System.out.println(s);

        System.out.println("主线程完成");

    }

}
