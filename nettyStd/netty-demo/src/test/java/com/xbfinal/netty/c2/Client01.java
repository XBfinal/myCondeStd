package com.xbfinal.netty.c2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

/**
 * @Title: Cliient01
 * @Author 笑霸fianl
 * @Package com.xbfinal.netty.c2
 * @Date 2023/5/17 19:09
 * @描述: 客户端 阻塞模式
 */
public class Client01 {
    public static void main(String[] args) throws IOException {
        SocketChannel open = SocketChannel.open();

        boolean connect = open.connect(new InetSocketAddress(8080));

        open.write(Charset.defaultCharset().encode("hello1"));

    }
}
