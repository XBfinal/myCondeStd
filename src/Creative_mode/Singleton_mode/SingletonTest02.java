package Creative_mode.Singleton_mode;

/**
 * @Title: SingletonTest02
 * @Author 笑霸fianl
 * @Package Creative_mode.Singleton_mode
 * @Date 2023/3/10 18:15
 * @描述: =========懒汉式=============
 */
public class SingletonTest02 {

    public static void main(String[] args) {


    }

}

/**
 * 懒汉式（线程不安全 ）【不可用】========================================================================
 * ==================================================================================================
 *
 * 优点：起到了Lazy Loading的效果，但是只能在单线程下使用。
 * 缺点：如果在多线程下，一个线程进入了if (singleton == null)判断语块，
 *      还未往下执行，另一个线程也通过了这个判断语句，这时便会产生多个实例在多线程环境下不可使用这种方式
 */
class Singleton3{

    private Singleton3(){}

    private static  Singleton3 instance;

    /**
     * 提供一个静态公有方法，当使用该方法时。才去创建instance
     */
    public static  Singleton3 getInstance(){
        if(instance==null){
            //没有创建才去创建
            instance = new Singleton3();
        }
        //返回实例
        return instance;
    }

}


/**
 * 懒汉式（线程安全 ,同步方法）【不可用】========================================================================
 * ===============================================================================================
 *
 * 优点：解决了线程不安全问题
 * 缺点：效率太低了，每个线程在想获得类的实例时候，
 *      执行getlnstance()方法都要‘synchronized同步’。而其实这个方法只执行一次实例化代码就够了，
 *      后面的想获得该直接return就行了。方法进行同步效率太低
 * 结论:在实际开发中，效率低   不推荐使用这种方式
 */
class Singleton4{

    private Singleton4(){}

    private static  Singleton4 instance;

    /**
     * 提供一个静态公有方法，加入了同步处理的代码 ，解决线程安全问题
     * 当使用该方法时。才去创建instance
     */
    public static synchronized Singleton4 getInstance(){
        if(instance==null){
            //没有创建才去创建
            instance = new Singleton4();
        }
        //返回实例
        return instance;
    }

}



/**
 * 懒汉式（线程安全 ,同步代码块）【不可用】========================================================================
 * ===============================================================================================
 *
 * 但是这种同步并不能起到线程同步的作用。跟第Singleton3实现方式遇到的情形一致，
 * 假如一个线程进入了if (singleton == null)判断语句块，还未来得及往下执行，
 * 另一个线程也通过了这个判断语句，这时便会产生多个实例。
 */
class Singleton5{

    private Singleton5(){}

    private static  Singleton5 instance;

    /**
     * 提供一个静态公有方法，加入了同步处理的代码 ，解决线程安全问题
     * 当使用该方法时。才去创建instance
     */
    public static  Singleton5 getInstance(){
        if(instance==null){
            synchronized(Singleton5.class){
                instance = new Singleton5();
            }
        }
        //返回实例
        return instance;
    }

}








