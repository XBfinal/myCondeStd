package com.xbfinal.myNet;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @Title: API_
 * @Author 笑霸fianl
 * @Package com.xbfinal.myNet
 * @Date 2023/4/2 8:30
 * @描述: InetAddress学习
 */
public class API_ {
    public static void main(String[] args) throws UnknownHostException {

        //获取本机的InetAddress 对象
        InetAddress localHost = InetAddress.getLocalHost();
        System.out.println(localHost);
        InetAddress localHost1 = Inet4Address.getLocalHost();
        System.out.println(localHost1);

        //根据域名和计算机名获取
        InetAddress finals = InetAddress.getByName("FINAL");//主机名不区分大小写
        InetAddress byName = InetAddress.getByName("www.xbfinal.top");
        System.out.println(finals);
        System.out.println(byName);




    }
}
