package com.xbfinal.myNet.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;


/**
 * @Title: SockerTCP01Server
 * @Author 笑霸fianl
 * @Package com.xbfinal.myNet.socket
 * @Date 2023/4/2 8:59
 * @描述: Socket的服务器端 接收消息
 */
public class SocketTCP01Server {
    public static void main(String[] args) throws IOException {

        //1,本机监听 9999 端口
        ServerSocket serverSocket = new ServerSocket(9999);
        System.out.println("监听9999  等待链接");


        //2,没有客户端链接9999 程序会阻塞  如果有链接 就会返回Socket对象
        Socket accept = serverSocket.accept();
        System.out.println("服务器端 返回："+accept.getClass());

        //得到输入流
        InputStream inputStream = accept.getInputStream();

        System.out.println("客服端消息：");
        // IO读取  读取数据
        byte[] bytes = new byte[1024];
        int redLen = 0;
        while ((redLen = inputStream.read(bytes)) != -1){
            //根据读取道德长度显示字符串
            System.out.println(new String(bytes,0,redLen));
        }
        System.out.println("==============");


        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("我收到你的信息了".getBytes(StandardCharsets.UTF_8));
        accept.shutdownOutput();//输出结束标记


       //关闭链接
        inputStream.close();
        accept.close();
        outputStream.close();
        serverSocket.close();
        System.out.println("服务退出");


    }
}
