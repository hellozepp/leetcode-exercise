package 设计模式.单例.最优单例;

public class Singleton {

    /**
     * 类级内部类，用于缓存类实例
     * 该类将在被调用时才会被装载，从而实现了延迟加载
     * 同时由于instance采用静态初始化的方式，因此JVM能保证其线程安全性
     */
    private static class Instance {
        private static Singleton instance = new Singleton();
    }

    /**
     * 私有化构造方法，使外部无法通过构造方法构造除instance外的类实例
     * 从而达到单例模式控制类实例数目的目的
     */
    private Singleton() {
        System.out.println("牛逼");
    }

    /**
     * 类实例的全局访问方法
     * 添加static关键词使得外部可以通过类名直接调用该方法获取类实例
     *
     * @return 单例类实例
     */
    public static Singleton getInstance() {
        return Instance.instance;
    }
}

class SingletonTest {
    public static void main(String[] args) throws Exception {
//        Class clazz = SingletonTest.class;
////////
////////        /*以下调用无参的、私有构造函数*/
////////        Constructor c0=  clazz.getDeclaredConstructor();
////////        c0.setAccessible(true);
////////        SingletonTest po=(SingletonTest)c0.newInstance();
////////        System.out.println("无参构造函数\t"+po);
////////
////////        /*以下调用带参的、私有构造函数*/
////////        Constructor c1=clazz.getDeclaredConstructor(new Class[]{String.class});
////////        c1.setAccessible(true);
////////        SingletonTest p1=(SingletonTest)c1.newInstance(new Object[]{"我是参数值"});
////////        System.out.println("有参的构造函数\t"+p1);
    }
}
