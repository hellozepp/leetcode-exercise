/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题65：不用加减乘除做加法
 * // 题目：写一个函数，求两个整数之和，要求在函数体内不得使用＋、－、×、÷
 * // 四则运算符号。
 */
package offer;
import java.math.BigInteger;

public class Java65_02_AddTwoNumbers {
    public int Add(int num1,int num2) {
        BigInteger bi1 = new BigInteger(String.valueOf(num1));
        BigInteger bi2 = new BigInteger(String.valueOf(num2));
        return bi1.add(bi2).intValue();
    }
}