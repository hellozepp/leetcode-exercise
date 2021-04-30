/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题14：剪绳子
 * // 题目：给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
 * // 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘
 * // 积是多少？例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此
 * // 时得到最大的乘积18。
 */
package offer;

public class Java14_CuttingRope {
	public static int maxCutting(int length) {
		if (length < 2) {
			return 0;
		}
		if (length == 2) {
			return 1;
		}
		if (length == 3) {
			return 2;
		}
		
		//将最优解存储在数组中，数组的第i个元素表示长度为i的绳子剪断后乘积的最大值
		int [] result = new int[length + 1];
		result[0] = 0;
		result[1] = 1;
		result[2] = 2;
		result[3] = 3;
		
		//自底向上开始求解
		int maxResult = 0;
		for (int i = 4; i <= length; i++) {
			int max = 0;
			for (int j = 1; j <= i / 2; j++) {
				int num = result[j] * result[i - j];
				if (max < num) {
					max = num;
				}
				result[i] = max;
			}
		}
		maxResult = result[length];
		return maxResult;
 	}
	
	//测试用例
	public static void main(String[] args) {
		Java14_CuttingRope testCut = new Java14_CuttingRope();
		System.out.println(testCut.maxCutting(8));
	}
}
