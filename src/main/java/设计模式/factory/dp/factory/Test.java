package 设计模式.factory.dp.factory;

/**
 * 简单工厂:
 * 控制实例的类型 和 创建过程
 */
public class Test {
	public static void main(String[] args) {
		//Car c = Car.getInstance();
		//Car c2 = Car.getInstance();
		VehicleFactory factory = new BroomFactory();
		Moveable m = factory.create();
		//if(c == c2) System.out.println("same car");
		m.run();
	}
}
