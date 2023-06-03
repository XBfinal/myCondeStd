package com.xbfinal.netty.chapter2;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

/**
 * @Title: HelloServer
 * @Author 笑霸fianl
 * @Package com.xbfinal.netty.chapter2
 * @Date 2023/6/3 20:02
 * @描述: Netty服务端
 */
public class HelloServer {
    public static void main(String[] args) {
        //1.启动器
        new ServerBootstrap()
                //2 选择服务 Scoket 实现类，其中 NioServerSocketChannel 表示基于 NIO 的服务器端实现
                .group(new NioEventLoopGroup())
                //3.选择服务器的 ServerSocketChannel实现
                .channel(NioServerSocketChannel.class)
                //4.决定了worker能执行哪些操作
                .childHandler(new ChannelInitializer<NioSocketChannel>() {

                    //4.1.添加具体的handler
                    @Override
                    protected void initChannel(NioSocketChannel ch) throws Exception {
                        //4.2.添加具体的handler
                        ch.pipeline().addLast(new StringDecoder());//编码器 把ByteBuf转为字符串
                        ch.pipeline().addLast(new ChannelInboundHandlerAdapter(){
                            @Override
                            public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
                                System.out.println(msg);
                            }
                        });
                    }
                })
                //5绑定端口
                .bind(8888);
    }
}
