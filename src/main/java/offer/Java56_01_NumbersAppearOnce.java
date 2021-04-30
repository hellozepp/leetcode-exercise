/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题56（一）：数组中只出现一次的两个数字
 * // 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序
 * // 找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
package offer;

public class Java56_01_NumbersAppearOnce {
	//基本思想：可以用位运算实现，如果将所有所有数字相异或，则最后的结果肯定是那两个只出现一次的数字异或
	//的结果。所以根据异或的结果1所在的最低位，把数字分成两半，每一半里都还有只出现一次的数据和成对出现的数据。
	//这样继续对每一半相异或则可以分别求出两个只出现一次的数字。num1,num2分别为长度为1的数组。传出参数
	//将num1[0],num2[0]设置为返回结果。
	public static void FindNumsAppearOnce(int[] array, int[] num1, int[] num2) {
		if (array == null || array.length <= 1) {
		    num1[0] = num2[0] = 0;
		    return;
		}
		int len = array.length, index = 0, sum = 0;
		for (int i = 0; i < len; i++) {
		    sum ^= array[i];
		}
		for (index = 0; index < 32; index++) {
		    if ((sum & (1 << index)) != 0) {
		    	break;
		    }
		}
		for (int i = 0; i < len; i++) {
		    if ((array[i] & (1 << index)) != 0) {
		        num2[0] ^= array[i];
		    }
		    else {
		        num1[0] ^= array[i];
		    }
		}
	}

	/**
	 * 数组a中只有一个数出现一次，其他数都出现了2次，找出这个数字
	 * @param a
	 * @return res
	 */
	public static int find1From2(int[] a) {
		int len = a.length, res = 0;
		for (int i = 0; i < len; i++) {
		    res = res ^ a[i];
		}
		return res;
	}

    /**
     * 数组a中只有一个数出现一次，其他数字都出现了3次，找出这个数字
     * @param a
     * @return res
     */
	public static int find1From3(int[] a) {
		int[] bits = new int[32];
		int len = a.length;
		for (int i = 0; i < len; i++) {
		    for (int j = 0; j < 32; j++) {
		        bits[j] = bits[j] + ((a[i] >>> j) & 1);
		    }
		}
		int res = 0;
		for (int i = 0; i < 32; i++) {
		    if (bits[i] % 3 !=0) {
		        res = res | (1 << i);
		    }
		}
		return res;
	}
}
