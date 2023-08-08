package Creative_mode.A04FactoryMode.A02FactoryMethodMode.carImpl;

import Creative_mode.A04FactoryMode.A02FactoryMethodMode.Car;

/**
 * @Title: BBCar
 * @Author 笑霸fianl
 * @Package Creative_mode.A04FactoryMode.A01Simple.carImpl
 * @Date 2023/8/3 16:44
 * @描述: bb车
 */
public class BBCar implements Car {
    @Override
    public void getInfo() {
        System.out.println("BB车");
    }
}
