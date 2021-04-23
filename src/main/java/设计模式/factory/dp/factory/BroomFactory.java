package 设计模式.factory.dp.factory;

public class BroomFactory extends VehicleFactory{
	public Moveable create() {
		return new Broom();
	}
}
