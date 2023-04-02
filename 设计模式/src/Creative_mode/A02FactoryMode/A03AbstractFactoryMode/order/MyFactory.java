package Creative_mode.A02FactoryMode.A03AbstractFactoryMode.order;

import Creative_mode.A02FactoryMode.A03AbstractFactoryMode.pizza.CheesePizza;
import Creative_mode.A02FactoryMode.A03AbstractFactoryMode.pizza.GreekPizza;
import Creative_mode.A02FactoryMode.A03AbstractFactoryMode.pizza.Pizza;

/**
 * @Title: MyFactory
 * @Author 笑霸fianl
 * @Package Creative_mode.A02FactoryMode.A03AbstractFactoryMode.order
 * @Date 2023/3/26 15:23
 * @描述:
 */
public class MyFactory implements AbsFactory{
    @Override
    public Pizza createPizza(String orderType) {

        Pizza pizza = null;

        System.out.println("使用  ==抽象工厂模式==  ");

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
