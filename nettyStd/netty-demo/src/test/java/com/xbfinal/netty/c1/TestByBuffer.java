package com.xbfinal.netty.c1;

import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Title: test
 * @Author 笑霸fianl
 * @Package com.xbfinal.netty.c1
 * @Date 2023/5/14 15:06
 * @描述: 测试
 */
@Slf4j
public class TestByBuffer {

    public static void main1(String[] args) {
        //读取文件
        try(FileChannel channel = new FileInputStream("nettyStd/netty-demo/src/main/resources/data.txt").getChannel()){
            //准备缓冲区
            ByteBuffer allocate = ByteBuffer.allocate(1024);//缓存区
            //向缓冲区里面写数据
            // 将字节序列从此通道读取到给定缓冲区中。
            //从此通道的当前文件位置开始读取字节，然后使用实际读取的字节数更新文件位置。
            // 否则，此方法的行为与接口中 ReadableByteChannel 指定的完全一样。
            channel.read(allocate);

            //切换模式
            allocate.flip();

            while (allocate.hasRemaining()){
                byte b = allocate.get();
                //byte b1 = allocate.get(0); 注意带参数的不会影响读指指针的移动
                System.out.print((char) b);
            }
            allocate.clear();

            int write = channel.write(allocate);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        try(FileChannel channel = new FileInputStream("nettyStd/netty-demo/src/main/resources/data.txt").getChannel()){

            ByteBuffer buffer = ByteBuffer.allocate(10);



            while (true){
                int read = channel.read(buffer);//会根据实际大小来读 返回-1则读取完毕
                log.info("当前 read的值 {} \t",read);
                if(read== -1)break;

                buffer.flip();//切换模式

                while (buffer.hasRemaining()){
                    byte b = buffer.get();
                    System.out.print((char) b);

                }
                System.out.println();
                buffer.clear();//清除此缓冲区。位置设置为零，限制设置为容量，标记被丢弃

            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }



}
