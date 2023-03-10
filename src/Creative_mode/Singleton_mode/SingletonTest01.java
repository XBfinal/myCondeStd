package Creative_mode.Singleton_mode;

/**
 * @Title: SingletonTesto1
 * @Author 笑霸fianl
 * @Package 创建型模式.单例模式
 * @Date 2023/3/10 16:25
 * @描述:
 * 一.单例模式的特点
 * 　1、单例类只能有一个实例。
 * 　2、单例类必须自己创建自己的唯一实例。
 * 　3、单例类必须给所有其他对象提供这一实例。
 * 单例模式保证了全局对象的唯一性，比如系统启动读取配置文件就需要单例保证配置的一致性。
 */
public class SingletonTest01 {
    public static void main(String[] args) {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance1==instance2);
        System.out.println(instance1.hashCode());
        System.out.println(instance2.hashCode());
    }

}
/**
 * 饿汉式(静态变量)
 *
 * 优点：这种写法比较简单，就是在类装载的时候就完成实例化。避免了步问题
 * 缺点：在类装载的时候就完成实例化，没有达到Lazy Loading（懒加载）的效果。如至终从未使用过这个实例，则会造成内存的浪费
 */
class Singleton{

    /**
     * 1.构造器私有化，防止外部new
     */
    private Singleton(){}

    /**
     * 在内部创建实例对象
     * 在内加载的时候创建对象实例
     */
    private final static Singleton instance=new Singleton();

    /**
     * 对外提供一个共有的静态方法返回这个实例
     */
    public static Singleton getInstance(){
        return instance;
    }
}
