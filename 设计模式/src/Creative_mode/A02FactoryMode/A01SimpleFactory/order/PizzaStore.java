package Creative_mode.A02FactoryMode.A01SimpleFactory.order;

/**
 * @Title: PizzaStore
 * @Author 笑霸fianl
 * @Package Creative_mode.A02FactoryMode.A01SimpleFactory.order
 * @Date 2023/3/25 15:32
 * @描述: 披萨订购，发出披萨的订购任务
 */
public class PizzaStore {
    public static void main(String[] args) {

        new OrderPizza(new SimpleFactory());
    }
}
