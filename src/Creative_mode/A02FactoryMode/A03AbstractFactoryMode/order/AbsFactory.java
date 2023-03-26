package Creative_mode.A02FactoryMode.A03AbstractFactoryMode.order;

import Creative_mode.A02FactoryMode.A03AbstractFactoryMode.pizza.Pizza;

/**
 * @Title: AbsFactory
 * @Author 笑霸fianl
 * @Package Creative_mode.A02FactoryMode.A03AbstractFactoryMode.order
 * @Date 2023/3/26 15:20
 * @描述:是一个抽象工厂模式的抽象层
 */
public interface AbsFactory {

    /**
     * 让下面的工厂方法子类实现
     * @param orderType
     * @return
     */
    public Pizza createPizza(String orderType);
}
