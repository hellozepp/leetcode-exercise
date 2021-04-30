/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题16：数值的整数次方
 * // 题目：实现函数double Power(double base, int exponent)，求base的exponent次方。
 * // 不得使用库函数，同时不需要考虑大数问题。
 */
package offer;

public class Java16_Power {
	public double Power(double base, int exponent) {
		double result = 0.0;
		if (equal(base, 0.0) && exponent < 0) {
			throw new RuntimeException("0的负数次幂无意义");
		}
		//这里定义0的0次方为1
		if (exponent == 0) {
			return 1.0;
		}
		if (exponent < 0) {
			result = powerWithExponent(1.0 / base, -exponent);
		}
		else {
			result = powerWithExponent(base, exponent);
		}
		return result;
	}
	
	private double powerWithExponent(double base, int exponent) {
		double result = 1.0;
		for (int i = 1; i <= exponent; i++) {
			result = result * base;
		}
		return result;
	}
	
	private boolean equal(double number1, double number2) {
		if ((number1 - number2) > -0.00000001 && (number1 - number2) < 0.00000001) {
			return true;
		}
		return false;
	}
	
	//测试用例
	public static void main(String[] args) {
		Java16_Power testPower = new Java16_Power();
		System.out.println(testPower.Power(2, 3));
		System.out.println(testPower.Power(2, 0));
		System.out.println(testPower.Power(2, -2));
		System.out.println(testPower.Power(0, 3));
		System.out.println(testPower.Power(0, 0));
		System.out.println(testPower.Power(-2, -2));
		System.out.println(testPower.Power(-2, -3));
		System.out.println(testPower.Power(0, -2));
	}
}
