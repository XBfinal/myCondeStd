package com.xbfinal.netty.c1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/**
 * @Title: TestFileChannerlTransferTo
 * @Author 笑霸fianl
 * @Package com.xbfinal.netty.c1
 * @Date 2023/5/15 16:03
 * @描述: 两个 FileChannel 传数据
 */
public class TestFileChannelTransferTo {

    public static void main(String[] args) {


        try(FileChannel from = new FileInputStream("nettyStd/netty-demo/src/main/resources/data.txt").getChannel();
            FileChannel to = new FileOutputStream("nettyStd/netty-demo/to1.txt").getChannel()
        ) {
            from.transferTo(0,from.size(),to);//最多只能传2g
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
