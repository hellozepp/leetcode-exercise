package 设计模式.factory.dp.factory;

public class CarFactory extends VehicleFactory{
	public Moveable create() {
		return new Car();
	}
}
