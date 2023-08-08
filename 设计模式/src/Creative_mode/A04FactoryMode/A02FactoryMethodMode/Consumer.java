package Creative_mode.A04FactoryMode.A02FactoryMethodMode;


import Creative_mode.A04FactoryMode.A02FactoryMethodMode.FactoryImpl.BBCarFactoryImpl;
import Creative_mode.A04FactoryMode.A02FactoryMethodMode.FactoryImpl.HQCarFactoryImpl;

/**
 * @Title: Consumer
 * @Author 笑霸fianl
 * @Package Creative_mode.A04FactoryMode.A01Simple
 * @Date 2023/8/3 16:45
 * @描述: 消费者
 */
public class Consumer {
    public static void main(String[] args) {

        Car car = new BBCarFactoryImpl().getCar();
        Car car1 = new HQCarFactoryImpl().getCar();
        car.getInfo();
        car1.getInfo();
        synchronized(car){
            System.out.println("哈哈哈");
        }

    }
}
