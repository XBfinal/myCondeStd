package Creative_mode.Singleton_mode;

/**
 * @Title: StaticInnerClass
 * @Author 笑霸fianl
 * @Package Creative_mode.Singleton_mode
 * @Date 2023/3/10 18:59
 * @描述: 单列模式-静态内部类
 *
 * 这种方式跟饿汉式方式采用的机制类似，但又有不同。
 * 两者都是采用了类装载的机制来保证初始化实例时只有一个线程。
 * 不同的地方在饿汉式方式是只要Singleton类被装载就会实例化，
 * 没有Lazy-Loading的作用，而静态内部类方式在Singleton类被装载时并不会立即实例化，
 * 而是在需要实例化时，调用getInstance方法，才会装载SingletonInstance类，从而完成Singleton的实例化。
 *
 * 类的静态属性只会在第一次加载类的时候初始化，
 * 所以在这里，JVM帮助我们保证了线程的安全性，在类进行初始化时，别的线程是无法进入的。

 */
public class StaticInnerClass {
    public static void main(String[] args) {

    }
}

/**
 * 特点：
 * 1.外部类装载时  静态内部类不会立即被装载
 * 2.调用getInstance() 静态内部类才会被装载而且只会装载一次
 *
 * 优点：避免了线程不安全，延迟加载，效率高。
 */
class Singleton7 {

    private Singleton7() {
    }


    /**
     * 静态内部类
     */
    private static class SingletonInstance {
        private static final Singleton7 INSTANCE = new Singleton7();
    }

    public static Singleton7 getInstance() {
        return SingletonInstance.INSTANCE;
    }

}






