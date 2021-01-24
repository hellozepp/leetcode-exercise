package 设计模式.proxy;


public class Client {
	public static void main(String[] args) throws Exception {
		Tank t = new Tank();
		InvocationHandler h = new TimeHandler(t);
		
		Moveable m = (Moveable)Proxy.newProxyInstance(Moveable.class, h);
		
		m.move();
	}
}
//���Զ�����Ķ�������Ľӿڷ�����ʵ������Ĵ���