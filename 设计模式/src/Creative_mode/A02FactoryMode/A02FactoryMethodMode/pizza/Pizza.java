package Creative_mode.A02FactoryMode.A02FactoryMethodMode.pizza;

/**
 * @Title: Pizza
 * @Author 笑霸fianl
 * @Package Creative_mode.A02FactoryMode.A01SimpleFactory.pizza
 * @Date 2023/3/25 15:07
 * @描述: 披萨抽象类
 */
public abstract class Pizza {


    /**
     * 披萨的名字
     */
    protected String name;


    /**
     *   //准备原材料
     */
    public abstract void prepare();

    public void bake() {
        System.out.println(name + "烘烤中");
    }


    public void cut() {
        System.out.println(name + "切割");
    }


    public void box() {
        System.out.println(name + "打包中");
    }

    public void setName(String name) {
        this.name = name;
    }
}
