package Creative_mode.A02FactoryMode.A01SimpleFactory.order;

import Creative_mode.A02FactoryMode.A01SimpleFactory.pizza.CheesePizza;
import Creative_mode.A02FactoryMode.A01SimpleFactory.pizza.GreekPizza;
import Creative_mode.A02FactoryMode.A01SimpleFactory.pizza.Pizza;

/**
 * @Title: SimpleFactory
 * @Author 笑霸fianl
 * @Package Creative_mode.A02FactoryMode.A01SimpleFactory.order
 * @Date 2023/3/25 15:44
 * @描述: 简单工厂类
 */
public class SimpleFactory {

    /**
     * 根据 orderType 返回实例
     * @param orderType
     * @return
     */
    public Pizza createPizza(String orderType){

        Pizza pizza = null;

        System.out.println("使用简单工厂模式");

        if (orderType.equals("greek")) {
            pizza = new GreekPizza();
            pizza.setName("greek");
        } else if (orderType.equals("cheese")) {
            pizza = new CheesePizza();
            pizza.setName("cheese");
        }
        return pizza;
    }
}
