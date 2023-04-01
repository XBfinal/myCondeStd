package com.xbfina.snowflake;

import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

/**
 * @Title: MyGetTime
 * @Author 笑霸fianl
 * @Package com.xbfina.snowflake
 * @Date 2023/4/1 10:06
 * @描述: 获取指定时间戳
 */
public class MyGetTime {

    @Test
    public static void get() throws ParseException {
        // 创建一个日期格式化对象
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 设置指定的日期时间
        String dateTime = "2023-04-01 0:0:00";
        // 将日期时间转换成Date对象
        Date date = sdf.parse(dateTime);
        // 获取指定日期时间的时间戳
        long timestamp = date.getTime();
        // 输出时间戳
        System.out.println(timestamp);
        System.out.println(Long.toBinaryString(timestamp));
        System.out.println("===============");
    }

    public static void getNow(){
        long timeMillis = System.currentTimeMillis();
        // 输出时间戳
        System.out.println(Long.toBinaryString(timeMillis));
    }

}
