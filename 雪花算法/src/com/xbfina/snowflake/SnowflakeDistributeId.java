package com.xbfina.snowflake;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Title: snowflakeDistributeId
 * @Author 笑霸fianl
 * @Package com.xbfina.snowflake
 * @Date 2023/4/1 9:43
 * @描述:
 */
public class SnowflakeDistributeId {

    /**
     *     设置开始时间戳(13位)
     *     时间是 2023-04-01 0:0:00
     */
    private final long twepoch = 1680278400000L;

    // 41-bit是时间戳    10-bit位可表示机器数   12-bit位是自增序列

    /**
     * 序列在id中占的位数
     */
    private final long sequenceBits = 12L;



    // 机器数10位 一般=  机器id所占的位数+数据标识id所占的位数 一共10 bit
    /**
     * 机器id所占的位数
     */
    private final long workerIdBits = 5L;

    /**
     * 数据标识id所占的位数
     */
    private final long datacenterIdBits = 5L;

    /**
     * 支持的最大机器id，结果是31 (这个移位算法可以很快的计算出几位二进制数所能表示的最大十进制数)
     * 2的5次方 是32 从0开始  0到31一共32位
     */
    private final long maxWorkerId = -1L ^ (-1L << workerIdBits);

    /**
     * 支持的最大数据标识id，结果是31
     */
    private final long maxDatacenterId = -1L ^ (-1L << datacenterIdBits);

    /**
     * 机器ID向左移12位
     */
    private final long workerIdShift = sequenceBits;

    /**
     * 数据标识id向左移17位(12+5)
     */
    private final long datacenterIdShift = sequenceBits + workerIdBits;

    /**
     * 时间截向左移22位(5+5+12)
     */
    private final long timestampLeftShift = sequenceBits + workerIdBits + datacenterIdBits;

    /**
     * 生成序列的掩码，这里为 4095 (0b111111111111=0xfff=4095)
     * 为了比较生成的序列号是否超出范围
     */
    private final long sequenceMask = -1L ^ (-1L << sequenceBits);

    /**
     * 工作机器ID(0~31)
     */
    private long workerId;

    /**
     * 数据中心ID(0~31)
     */
    private long datacenterId;

    /**
     * 毫秒内序列(0~4095)
     */
    private long sequence = 0L;

    /**
     * 上次生成ID的时间截
     */
    private long lastTimestamp = -1L;



    /**
     * 构造函数
     *
     * @param workerId     工作ID (0~31)
     * @param datacenterId 数据中心ID (0~31)
     *        工作ID  +   数据中心ID  = 10bit的工作机器id
     */
    public SnowflakeDistributeId( long datacenterId,long workerId) {
        //maxWorkerId 是机器最大id 31
        if (workerId > maxWorkerId || workerId < 0) {
            //工作ID超过或最大值 或小于o  就抛出异常
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (datacenterId > maxDatacenterId || datacenterId < 0) {
            //maxDatacenterId 数据标识id 最大值是 31
            throw new IllegalArgumentException(String.format("datacenter Id can't be greater than %d or less than 0", maxDatacenterId));
        }
        this.workerId = workerId;
        this.datacenterId = datacenterId;
    }

    /**
     * 获得下一个ID (该方法是线程安全的)
     *
     * @return SnowflakeId
     */
    public synchronized long nextId() throws InterruptedException {

        //获取当前时间戳
        long timestamp = System.currentTimeMillis();

        //如果当前时间小于上一次ID生成的时间戳，说明系统时钟回退过这个时候应当抛出异常
        if (timestamp < lastTimestamp) {
            throw new RuntimeException(
                    String.format("Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
        }

        //如果是同一时间生成的，则进行毫秒内序列
        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            //毫秒内序列溢出
            if (sequence == 0) {
                //阻塞到下一个毫秒,获得新的时间戳
                Thread.sleep(1);
                timestamp = System.currentTimeMillis();
            }
        }
        //时间戳改变，毫秒内序列重置
        else {
            sequence = 0L;
        }

        //上次生成ID的时间截
        lastTimestamp = timestamp;

        //移位并通过或运算拼到一起组成64位的ID
        //我把符号位制1


        return 1<<63
                |((timestamp - twepoch) << timestampLeftShift) //移动22
                | (datacenterId << datacenterIdShift) //移动17
                | (workerId << workerIdShift) //左移12
                | sequence;
    }






}
