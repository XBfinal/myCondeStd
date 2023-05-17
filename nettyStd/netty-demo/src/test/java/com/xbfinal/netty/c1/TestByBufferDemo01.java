package com.xbfinal.netty.c1;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/**
 * @Title: TestByBufferDemo01
 * @Author 笑霸fianl
 * @Package com.xbfinal.netty.c1
 * @Date 2023/5/15 15:28
 * @描述: 粘包 半包 解析
 */
public class TestByBufferDemo01 {

    public static void main(String[] args) {
        ByteBuffer buffer = ByteBuffer.allocate(50);
        buffer.put("hello\nworld\nmy name i".getBytes()); //粘包 半包

        hello(buffer);
        buffer.put("s xbfinal!\n".getBytes());// 半包
        hello(buffer);
    }

    public static void hello(ByteBuffer buffer){
        //进来先转化为读模式
        buffer.flip();
        for (int i = buffer.position(); i <buffer.limit() ; i++) {
            if('\n' == buffer.get(i)){
                // 我们先存入新的ByteBuffer
                int len = i -buffer.position();
                ByteBuffer allocate = ByteBuffer.allocate(len);
                for (int j = 0; j < len; j++) {
                    allocate.put(buffer.get());
                }
                //输出
                allocate.flip();
                for (int j = 0; j < len; j++) {
                    System.out.print((char) allocate.get());
                }
            }



        }
        //这里由于有粘包 半包。不能用clear
        buffer.compact();


    }

}
