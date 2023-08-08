package Creative_mode.A04FactoryMode.A02FactoryMethodMode.FactoryImpl;

import Creative_mode.A04FactoryMode.A02FactoryMethodMode.Car;
import Creative_mode.A04FactoryMode.A02FactoryMethodMode.CarFactory;
import Creative_mode.A04FactoryMode.A02FactoryMethodMode.carImpl.HQCar;

/**
 * @Title: HQCarFactoryImpl
 * @Author 笑霸fianl
 * @Package Creative_mode.A04FactoryMode.A02FactoryMethodMode.FactoryImpl
 * @Date 2023/8/3 17:17
 * @描述:
 */
public class HQCarFactoryImpl implements CarFactory {
    @Override
    public Car getCar() {
        return new HQCar();
    }
}
