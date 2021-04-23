package 设计模式.factory.dp.factory.abstractfactory;

public class DefaultFactory extends AbstractFactory{

	@Override
	public Food createFood() {
		// TODO Auto-generated method stub
		return new Apple();
	}

	@Override
	public Vehicle createVehicle() {
		// TODO Auto-generated method stub
		return new Car();
	}

	@Override
	public Weapon createWeapon() {
		// TODO Auto-generated method stub
		return new AK47();
	}
	
}
