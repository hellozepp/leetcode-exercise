package 设计模式.观察者;

public class F_Observer extends Observer {
    public void update(String msg) {
        System.out.println(F_Observer.class.getName() + " : " + msg);
    }
}