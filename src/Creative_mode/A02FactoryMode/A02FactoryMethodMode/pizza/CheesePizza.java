package Creative_mode.A02FactoryMode.A02FactoryMethodMode.pizza;

/**
 * @Title: CheesePizza
 * @Author 笑霸fianl
 * @Package Creative_mode.A02FactoryMode.A01SimpleFactory.pizza
 * @Date 2023/3/25 15:14
 * @描述: 奶酪披萨
 */
public class CheesePizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("给制作==奶酪披萨==准备原材料");
    }

}
