package Creative_mode.A04FactoryMode.A02FactoryMethodMode.FactoryImpl;

import Creative_mode.A04FactoryMode.A02FactoryMethodMode.Car;
import Creative_mode.A04FactoryMode.A02FactoryMethodMode.CarFactory;
import Creative_mode.A04FactoryMode.A02FactoryMethodMode.carImpl.BBCar;

/**
 * @Title: BBCarFactoryImpl
 * @Author 笑霸fianl
 * @Package Creative_mode.A04FactoryMode.A02FactoryMethodMode.FactoryImpl
 * @Date 2023/8/3 17:15
 * @描述: BB车工厂
 */
public class BBCarFactoryImpl implements CarFactory {
    @Override
    public Car getCar() {
        return new BBCar();
    }
}
