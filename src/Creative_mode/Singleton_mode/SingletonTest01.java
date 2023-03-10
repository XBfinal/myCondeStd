package Creative_mode.Singleton_mode;

/**
 * @Title: SingletonTesto1
 * @Author 笑霸fianl
 * @Package 创建型模式.单例模式
 * @Date 2023/3/10 16:25
 * @描述:=========饿汉式================
 */
public class SingletonTest01 {
    /**
     *  一.单例模式的特点
     *  * 　1、单例类只能有一个实例。
     *  * 　2、单例类必须自己创建自己的唯一实例。
     *  * 　3、单例类必须给所有其他对象提供这一实例。
     *  * 单例模式保证了全局对象的唯一性，比如系统启动读取配置文件就需要单例保证配置的一致性。
     * @param args
     */
    public static void main(String[] args) {
        Singleton1 instance1 = Singleton1.getInstance();
        Singleton1 instance2 = Singleton1.getInstance();
        System.out.println(instance1==instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }

}
/**
 * =============饿汉式(静态变量)【可用】================================================================================
 *
 * 优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了步问题
 * 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading（懒加载）的效果。
 *      如至终从未使用过这个实例，则会造成内存的浪费
 *
 */
class Singleton1{

    /**
     * 1.构造器私有化，防止外部new
     */
    private Singleton1(){}

    /**
     * 在内部创建实例对象
     * 在内加载的时候创建对象实例
     */
    private final static Singleton1 instance=new Singleton1();

    /**
     * 对外提供一个共有的静态方法返回这个实例
     */
    public static Singleton1 getInstance(){
        return instance;
    }
}

/**
 * ============饿汉式(静态代码块)【可用】=============================================================================
 *
 * 优缺点：和饿汉式(静态变量)类似
 *        只不过将类实例化的过程放在了静态代码块中，
 *        也是在类装载的时候，就执行静态代码块中的代码，
 *        初始化类的实例。优缺点和上面是一样的。
 */
class Singleton2{
    /**
     * 1.构造器私有化，防止外部new
     */
    private Singleton2(){}

    /**
     * 在静态代码块中创建实例对象
     */
    private static  Singleton2 instance;
    static {
        instance=new Singleton2();
    }

    /**
     * 对外提供一个共有的静态方法返回这个实例
     */
    public static Singleton2 getInstance(){
        return instance;
    }

}


