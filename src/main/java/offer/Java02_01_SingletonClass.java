/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题2：实现Singleton模式
 * // 题目：设计一个类，我们只能生成该类的一个实例。
 */
package offer;

/** 饥汉模式 */
public class Java02_01_SingletonClass {
	private static final Java02_01_SingletonClass instance = new Java02_01_SingletonClass();
	//私有构造函数
	private Java02_01_SingletonClass(){}
	public static Java02_01_SingletonClass getIntance() {
		return instance;
	}
}