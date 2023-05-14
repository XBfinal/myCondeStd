package com.xbfinal.netty.c1;

import lombok.extern.slf4j.Slf4j;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @Title: TestByBufferString
 * @Author 笑霸fianl
 * @Package com.xbfinal.netty.c1
 * @Date 2023/5/14 16:17
 * @描述:
 */
@Slf4j
public class TestByBufferString {
    private static String MY_STR="你好啊 世界";
    private static String MY_STR1="holle word";

    public static void main(String[] args) {


        log.info("字符串  ====》 byte  ");

        log.info("1.getBytes() ");
        ByteBuffer allocate = ByteBuffer.allocate(1024);
//        allocate.put(MY_STR.getBytes()); 默认使用系统自带的编码方式
        allocate.put(MY_STR1.getBytes(StandardCharsets.UTF_8));//不会自动转化为读模式
        allocate.flip();
        while (allocate.hasRemaining()){
            System.out.print( (char) allocate.get());
        }
        System.out.println("\n=================");

        log.info(" 2.wrap ");
        ByteBuffer wrap = ByteBuffer.wrap(MY_STR1.getBytes());//会自动转化为读模式
        while (wrap.hasRemaining()){
            System.out.print( (char) wrap.get());
        }
        System.out.println("\n=================");

        log.info(" 3.Charset ");
        ByteBuffer encode = StandardCharsets.UTF_8.encode(MY_STR1);//会自动转化为读模式

        while (encode.hasRemaining()){
            System.out.print( (char) encode.get());
        }
        System.out.println("\n=================");




        log.info(" byte  ====》 字符串   ");
        log.info(" 3.Charset ");
        ByteBuffer encode1 = StandardCharsets.UTF_8.encode(MY_STR);//会自动转化为读模式
        String s = StandardCharsets.UTF_8.decode(encode1).toString();//调用这个之前一定要让ByteBuffer为读模式
        System.out.println(s);
    }
}
