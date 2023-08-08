package Creative_mode.A04FactoryMode.A01Simple;

import Creative_mode.A04FactoryMode.A01Simple.factory.CarFactory;

/**
 * @Title: Consumer
 * @Author 笑霸fianl
 * @Package Creative_mode.A04FactoryMode.A01Simple
 * @Date 2023/8/3 16:45
 * @描述: 消费者
 */
public class Consumer {
    public static void main(String[] args) {
        Car car1 = CarFactory.getCar("红旗");
        Car car2 = CarFactory.getCar("BB车");

        car1.getInfo();
        car2.getInfo();
    }
}
