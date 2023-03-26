package Creative_mode.A02FactoryMode.A03AbstractFactoryMode.order;



import Creative_mode.A02FactoryMode.A03AbstractFactoryMode.pizza.Pizza;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Title: OrderPizza
 * @Author 笑霸fianl
 * @Package Creative_mode.A02FactoryMode.A03AbstractFactoryMode.order
 * @Date 2023/3/26 15:28
 * @描述:
 */
public class OrderPizza {
    AbsFactory absFactory;

    public OrderPizza(AbsFactory Factory){
        setAbsFactory(Factory);
    }

    private void  setAbsFactory(AbsFactory Factory){
        Pizza pizza = null;
        this.absFactory = Factory;

        //订购披萨的类型
        String orderType;
        do {
            orderType =  getByType();
            pizza=absFactory.createPizza(orderType);
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
