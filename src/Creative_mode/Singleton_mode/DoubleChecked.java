package Creative_mode.Singleton_mode;

/**
 * @Title: DoubleChecked
 * @Author 笑霸fianl
 * @Package Creative_mode.Singleton_mode
 * @Date 2023/3/10 18:48
 * @描述: 双重检查
 */
public class DoubleChecked {
    public static void main(String[] args) {

    }
}

/**
 * 双重检查================================================================================
 * ======================================================================================
 * 优点说明:
 *     Double-Check概念是多线程开发中常使用到的，如代码中所示，
 *     我们进行次if (singleton == null)检查，这样就可以保证线程安全了
 *
 *     这样，实例化代码只用执行一次，后面再次访问时，判断if (singleton =null)直接return实例化对象，
 *     也避免的反复进行方法同步
 *
 *     线程安全;延迟加载;效率较高
 * 结论: 在实际开发中，推荐使用这种单例设计模式
 */
class Singleton{

    private static volatile Singleton instance;
    private Singleton(){}

    /**
     * 提供一个静态公有方法，加入双重检查的代码 ，解决线程安全问题，同时解决懒加载问题
     * 也保证了效率
     */
    public static synchronized Singleton getInstance(){
        if(instance==null){
            synchronized(Singleton.class){
                if(instance==null){
                    instance = new Singleton();
                }
            }
        }
        //返回实例
        return instance;
    }

}
