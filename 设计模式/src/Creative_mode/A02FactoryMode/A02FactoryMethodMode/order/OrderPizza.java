package Creative_mode.A02FactoryMode.A02FactoryMethodMode.order;

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
public abstract class OrderPizza {



    /**
     * ++++++++++++++++++++++++++++++++++++++++++++++++
     * 定义一个抽象方法，让各个工厂子类自己去实现
     * @param orderType
     * @return
     */
    abstract Pizza creatPizza(String orderType);

    /**
     * 构造器
     */
        public OrderPizza() {

        Pizza pizza = null;

        //订购披萨的类型
        String orderType;

        do {
            orderType =  getByType();

            //抽象方法由工厂子类实现
            pizza=creatPizza(orderType);
            if(pizza==null){
                System.out.println("没有此类型");
                System.out.println("===============");
                break;
            }

            //输出 披萨制作的过程
            pizza.prepare();
            pizza.bake();
            pizza.cut();
            pizza.box();
            System.out.println("===============");
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
