/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题66：构建乘积数组
 * // 题目：给定一个数组A[0, 1, …, n-1]，请构建一个数组B[0, 1, …, n-1]，其
 * // 中B中的元素B[i] =A[0]×A[1]×… ×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 */
package offer;

public class Java66_ConstuctArray {
	public int[] multiply(int[] A) {
		int length = A.length;
		int forword[] = new int[length];
		int backword[] = new int[length];
		int B[] = new int[length];
		forword[0] = 1;
		backword[0] = 1;
		for (int i = 1; i < length; i++) {
			forword[i] = A[i - 1] * forword[i - 1];
			backword[i] = A[length - i] * backword[i - 1];
		}
		for (int i = 0; i < length; i++) {
			B[i] = forword[i] * backword[length - i - 1];
		}
		return B;
	}
}