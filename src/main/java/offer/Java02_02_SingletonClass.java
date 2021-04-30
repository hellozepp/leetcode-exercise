/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题2：实现Singleton模式
 * // 题目：设计一个类，我们只能生成该类的一个实例。
 */
package offer;

/** 线程安全的懒汉模式 */
public class Java02_02_SingletonClass {
	private static Java02_02_SingletonClass instance;
	//私有构造函数
	private Java02_02_SingletonClass(){}
	public static synchronized Java02_02_SingletonClass getInstance() {
		if (instance == null) {
			instance = new Java02_02_SingletonClass();
		}
		return instance;
	}
}