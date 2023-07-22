package com.xbfina.snowflake;

import org.testng.annotations.Test;

import java.text.ParseException;

/**
 * @Title: MyMain
 * @Author 笑霸fianl
 * @Package com.xbfina.snowflake
 * @Date 2023/4/1 9:33
 * @描述: 雪花算法实现
 */
public class MyMain {
    public static void main(String[] args) throws ParseException, InterruptedException {
//        MyGetTime.get();
//        System.out.println("===========");
//
//        System.out.println("===================");
        demo snowflakeDistributeId = new demo(0, 1);
        for (int i = 0; i < 5; i++) {
            long id = snowflakeDistributeId.nextId();

            System.out.println(id+"对应的二进制"+Long.toBinaryString(id));
            System.out.println(Long.toBinaryString(id));
//
//            System.out.println("时间戳的差");
//            System.out.println(Long.toBinaryString( System.currentTimeMillis()-1680278400000L));
//            System.out.println("==================");
        }

    }
    @Test
    void text02() {
        long l = System.currentTimeMillis();//当前时间戳

        /**
         *     设置开始时间戳(13位)
         *     时间是 2023-04-01 0:0:00
         */
        final long twepoch = 1680278400000L;

        System.out.println(l-twepoch);


    }

    @Test
    void text01(){
        //1073741824
        long id= 1680278400000L<<22;
        System.out.println(id);
        System.out.println(Long.toBinaryString(id));
    }


    /**
     * 测试java中的注解是否会执行
     */
    @Test
    void text11(){
        int name=100;
        System.out.println("注释之前 name="+name);
        // \u000d name=123;
        System.out.println("注释之后 name="+name);

    }



}
