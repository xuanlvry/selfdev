package design.creater.singleton;

/**
 * 单例模式
 *
 * @author Chengfei.Sun on 2016/9/30.
 */
public class Singleton {
    private volatile static Singleton singleton;

    private Singleton() {
    }

    /**
     * 双检锁/双重校验锁（DCL，即 double-checked locking）
     * JDK 版本：JDK1.5 起
     * 是否 Lazy 初始化：是
     * 是否多线程安全：是
     * 实现难度：较复杂
     * 描述：这种方式采用双锁机制，安全且在多线程情况下能保持高性能。
     * getInstance() 的性能对应用程序很关键。
     *
     * @return
     */
    public static Singleton getSingleton() {
        if (singleton == null) {
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }

    /**
     * 懒汉式，线程安全
     * 是否 Lazy 初始化：是
     * 是否多线程安全：是
     * 实现难度：易
     * 描述：这种方式具备很好的 lazy loading，能够在多线程中很好的工作，但是，效率很低，99% 情况下不需要同步。
     * 优点：第一次调用才初始化，避免内存浪费。
     * 缺点：必须加锁 synchronized 才能保证单例，但加锁会影响效率。
     * getInstance() 的性能对应用程序不是很关键（该方法使用不太频繁）。
     *
     * @return
     */
    public static synchronized Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }

    public static void main(String[] args) {

    }
}
