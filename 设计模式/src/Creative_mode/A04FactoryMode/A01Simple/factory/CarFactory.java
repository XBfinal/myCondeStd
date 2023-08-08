package Creative_mode.A04FactoryMode.A01Simple.factory;

import Creative_mode.A04FactoryMode.A01Simple.Car;
import Creative_mode.A04FactoryMode.A01Simple.carImpl.BBCar;
import Creative_mode.A04FactoryMode.A01Simple.carImpl.HQCar;

import java.util.HashMap;
import java.util.Map;

/**
 * @Title: CarFactory
 * @Author 笑霸fianl
 * @Package Creative_mode.A04FactoryMode.A01Simple.factory
 * @Date 2023/8/3 16:41
 * @描述: 汽车工厂
 */
public class CarFactory {

    private static final Map<String, Car> carHashMap = new HashMap<String, Car>();

    static {
        carHashMap.put("红旗",new HQCar());
        carHashMap.put("BB车",new BBCar());
    }

    public static Car getCar(String name){
        return carHashMap.get(name);
    }


//    public static Car getCar(String name){
//        if("红旗".equals(name)){
//            return new HQCar();
//        }else if("BB车".equals(name)){
//            return new BBCar();
//        }else {
//            return null;
//        }
//    }

}
