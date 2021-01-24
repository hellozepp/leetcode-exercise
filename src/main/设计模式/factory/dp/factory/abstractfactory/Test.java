package 设计模式.factory.dp.factory.abstractfactory;

/**
 * 抽象工厂
 * 控制一系列工厂实例的类型和生产过程
 */
public class Test {
    public static void main(String[] args) {
        //DefaultFactory f = new DefaultFactory();
        AbstractFactory f = new DefaultFactory();
        Vehicle v = f.createVehicle();
        v.run();
        Weapon w = f.createWeapon();
        w.shoot();
        Food a = f.createFood();
        a.printName();
    }
}
