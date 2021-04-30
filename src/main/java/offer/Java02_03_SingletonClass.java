/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题2：实现Singleton模式
 * // 题目：设计一个类，我们只能生成该类的一个实例。
 */
package offer;

/** 双重校验锁法 */
public class Java02_03_SingletonClass {
	private volatile static Java02_03_SingletonClass instance;
	//私有构造函数
	private Java02_03_SingletonClass() {
		System.out.println("Singleton has loaded");
	}
	public static Java02_03_SingletonClass getInstance() {
		if (instance == null) {
			synchronized (Java02_03_SingletonClass.class) {
				if (instance == null) {
					instance = new Java02_03_SingletonClass();
				}
			}
		}
		return instance;
	}
}