package Creative_mode.A03BuilderMode;

/**
 * @Title: AbstractHouse
 * @Author 笑霸fianl
 * @Package Creative_mode.A03BuilderMode
 * @Date 2023/3/27 13:20
 * @描述:
 */
public abstract class  AbstractHouse {

    /**
     *  /打地基
     */
    public abstract void buildBasic();

    /**
     *  /切墙
     */
    public abstract void buildWalls();

    /**
     * /封顶
     */
    public abstract void roofed();

    public void build(){
        buildBasic();
        buildWalls();
        roofed();
    }
}
