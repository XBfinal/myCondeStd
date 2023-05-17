package com.xbfinal.netty.c2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @Title: Server
 * @Author 笑霸fianl
 * @Package com.xbfinal.netty.c2
 * @Date 2023/5/17 18:54
 * @描述: 服务端   阻塞模式
 */
public class Server01 {

    public static void main(String[] args) throws IOException {

        //创建服务器
        ServerSocketChannel serverSocketChannel
                =  ServerSocketChannel.open();

        //监听端口
        ServerSocketChannel bind
                = serverSocketChannel.bind(new InetSocketAddress(8080));


        while (true){

            SocketChannel accept = bind.accept();//阻塞  得到一个通道
            ByteBuffer buffer =  ByteBuffer.allocate(16);

            accept.read(buffer);//管道读取到buffer

            buffer.flip();

            myRed(buffer);

            buffer.clear();


        }

    }

    static void myRed(ByteBuffer buffer){
        while (buffer.hasRemaining()){
            System.out.print((char) buffer.get());
        }
    }
}
