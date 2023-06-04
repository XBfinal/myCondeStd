package com.xbfinal.netty.chapter2;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.internal.StringUtil;

import java.util.Scanner;

/**
 * @Title: HelloClinet
 * @Author 笑霸fianl
 * @Package com.xbfinal.netty.chapter2
 * @Date 2023/6/3 20:09
 * @描述: Netty客户端
 */
public class HelloClient {
    public static void main(String[] args) throws InterruptedException {
        //1.启动类
        Channel localhost = new Bootstrap()
                //2.添加EventLoop
                .group(new NioEventLoopGroup())
                //3.选择客户端实现
                .channel(NioSocketChannel.class)
                //4添加处理器
                .handler(new ChannelInitializer<NioSocketChannel>() {
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        ch.pipeline().addLast(new StringEncoder());
                    }
                })
                //5.链接到服务器
                .connect("localhost", 8888)
                .sync()
                .channel();
//                //6.向服务器发送数据
//                .writeAndFlush("你好 世界");



        //循环发送消息
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入文字");
        String str = scanner.next();
        while (str == null || str.isEmpty()){
            localhost.writeAndFlush(str);
            System.out.println("请输入文字");
            str = scanner.next();
        }


    }
}
