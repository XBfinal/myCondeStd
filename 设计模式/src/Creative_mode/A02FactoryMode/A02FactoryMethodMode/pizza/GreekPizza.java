package Creative_mode.A02FactoryMode.A02FactoryMethodMode.pizza;

/**
 * @Title: GreekPizza
 * @Author 笑霸fianl
 * @Package Creative_mode.A02FactoryMode.A01SimpleFactory.pizza
 * @Date 2023/3/25 15:16
 * @描述: 希腊披萨
 */
public class GreekPizza extends Pizza {
    @Override
    public void prepare() {
        System.out.println("给制作==希腊披萨==准备原材料");
    }
}
