package Creative_mode.A02FactoryMode.A02FactoryMethodMode.order;

import Creative_mode.A02FactoryMode.A01SimpleFactory.pizza.CheesePizza;
import Creative_mode.A02FactoryMode.A01SimpleFactory.pizza.GreekPizza;
import Creative_mode.A02FactoryMode.A01SimpleFactory.pizza.Pizza;

/**
 * @Title: OrderFactory
 * @Author 笑霸fianl
 * @Package Creative_mode.A02FactoryMode.FactoryMethodMode.order
 * @Date 2023/3/26 14:54
 * @描述:
 */
public class OrderFactory extends OrderPizza{
    @Override
    Pizza creatPizza(String orderType) {

        Pizza pizza = null;

        System.out.println("使用  ==工厂方法模式==  ");

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
