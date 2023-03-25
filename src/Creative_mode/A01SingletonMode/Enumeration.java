package Creative_mode.A01SingletonMode;

/**
 * @Title: Enumeration
 * @Author 笑霸fianl
 * @Package Creative_mode.Singleton_mode
 * @Date 2023/3/10 19:24
 * @描述: 枚举
 */
public class Enumeration {
    public static void main(String[] args) {

        Singleton singleton1 = Singleton.INSTANCE;
        Singleton singleton2 = Singleton.INSTANCE;
        System.out.println(singleton1==singleton2);
        System.out.println(singleton1.hashCode());
        System.out.println(singleton2.hashCode());
    }
}


/**
 * 枚举========================
 *
 * 借助JDK1.5中添加的枚举来实现单例模式。不仅能避免多线程同步问题，而且还能防止反序列化重新创建新的对象
 */
enum Singleton{
    //属性
    INSTANCE;
    public void sayOK(){}
}
