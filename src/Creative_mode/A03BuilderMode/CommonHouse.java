package Creative_mode.A03BuilderMode;



/**
 * @Title: CommonHouse
 * @Author 笑霸fianl
 * @Package Creative_mode.A03BuilderMode
 * @Date 2023/3/27 13:24
 * @描述:
 */
public class CommonHouse extends  AbstractHouse{

    @Override
    public void buildBasic() {
        System.out.println("普通房子  打地基");
    }

    @Override
    public void buildWalls() {
        System.out.println("普通房子  砌墙");

    }

    @Override
    public void roofed() {
        System.out.println("普通房子  封顶");

    }
}
