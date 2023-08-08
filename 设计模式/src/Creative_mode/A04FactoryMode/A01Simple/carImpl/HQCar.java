package Creative_mode.A04FactoryMode.A01Simple.carImpl;

import Creative_mode.A04FactoryMode.A01Simple.Car;

/**
 * @Title: HQCar
 * @Author 笑霸fianl
 * @Package Creative_mode.A04FactoryMode.A01Simple.carImpl
 * @Date 2023/8/3 16:39
 * @描述: 红旗车
 */
public class HQCar implements Car {
    @Override
    public void getInfo() {
        System.out.println("红旗车");
    }
}
