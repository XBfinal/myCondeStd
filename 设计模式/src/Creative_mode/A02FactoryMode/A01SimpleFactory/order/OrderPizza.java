package Creative_mode.A02FactoryMode.A01SimpleFactory.order;

import Creative_mode.A02FactoryMode.A01SimpleFactory.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Title: OrderPizza
 * @Author 笑霸fianl
 * @Package Creative_mode.A02FactoryMode.A01SimpleFactory.order
 * @Date 2023/3/25 15:19
 * @描述: 订购披萨
 */
public class OrderPizza {


//    public OrderPizza() {
//
//        Pizza pizza = null;
//
//        //订购披萨的类型
//        String orderType;
//
//        do {
//            orderType =  getByType();
//            if (orderType.equals("greek")) {
//                pizza = new GreekPizza();
//                pizza.setName("greek");
//            } else if (orderType.equals("cheese")) {
//                pizza = new CheesePizza();
//                pizza.setName("cheese");
//            } else {
//                break;
//            }
//
//            //输出 披萨制作的过程
//            pizza.prepare();
//            pizza.bake();
//            pizza.cut();
//            pizza.box();
//
//        } while (true);
//
//    }



    /**
     * 定义一个简单工厂对象
     */
    SimpleFactory simpleFactory;
    Pizza pizza = null;

    /**
     * 构造器
     */
    public OrderPizza(SimpleFactory simpleFactory){
        setSimpleFactory(simpleFactory);
    }
    /**
     * 设置一个工厂
     */
    public void setSimpleFactory(SimpleFactory simpleFactory) {
        //用户输入得到
        String orderType = "";
        this.simpleFactory = simpleFactory;

        do {
            orderType = getByType();
            pizza = this.simpleFactory.createPizza(orderType);

            //输出信息
            if (pizza != null) {

                pizza.prepare();

                pizza.bake();

                pizza.cut();

                pizza.box();

            } else {
                System.out.println("没有此披萨");
                break;
            }
        } while (true);
    }


    /**
     * 获取用户希望订购的披萨种类
     */
    private String getByType() {

        try {

            BufferedReader strIn = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("请输入==披萨==的种类");
            String str = strIn.readLine();
            return str;

        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
