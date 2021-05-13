package 设计模式.单例.最优单例.quiz;

public class Singleton {
    private Singleton() {
    }

    private static class SingletonHelper {
        static {
            System.out.println("单例被初始化");
        }

        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        System.out.println("开始访问单例");
        return SingletonHelper.instance;
    }

    public static void main(String[] args) {
        System.out.println("调用方启动");
        Singleton.getInstance();
    }
}
