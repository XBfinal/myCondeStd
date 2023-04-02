package com.xbfinal.myNet.socket;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

import java.nio.charset.StandardCharsets;

/**
 * @Title: SocketTCP01Client
 * @Author 笑霸fianl
 * @Package com.xbfinal.myNet.socket
 * @Date 2023/4/2 9:05
 * @描述: Socket的服务器端 发送消息
 */
public class SocketTCP01Client {
    public static void main(String[] args) throws Exception {

        //思路
        //1。连接服狂端 (ip ，端口) 链接本机的9999端口
        Socket socket = new Socket(InetAddress.getLocalHost(), 9999);
        System.out.println("客服端 返回" + socket.getClass());

        //2。连接上后，生成Socket，通过//socket.getOutputStream()
        OutputStream outputStream = socket.getOutputStream();

        // 3。通过输出流，写入数据到 数据通道
        outputStream.write("你好 服务端".getBytes(StandardCharsets.UTF_8));
        socket.shutdownOutput();

        //读取服务端的消息
        System.out.println("服务端消息：");
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(bytes)) != -1 ){
            System.out.println(new String(bytes,0,len));
        }
        System.out.println("============");

        //4.关闭链接
        outputStream.close();
        socket.close();
        inputStream.close();
        System.out.println("客服端退出");




    }
}
