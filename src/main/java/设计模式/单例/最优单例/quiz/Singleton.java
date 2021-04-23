package 设计模式.单例.最优单例.quiz;

public class Singleton {
    private Singleton() {
    }

    private static class SingletonHelper {
        private static Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonHelper.instance;
    }
}
