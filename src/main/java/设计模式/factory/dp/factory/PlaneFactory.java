package 设计模式.factory.dp.factory;

public class PlaneFactory extends VehicleFactory{
	public Moveable create() {
		return new Plane();
	}
}
