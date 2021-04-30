/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题67：把字符串转换成整数
 * // 题目：请你写一个函数StrToInt，实现把字符串转换成整数这个功能。当然，不
 * // 能使用atoi或者其他类似的库函数。
 */
package offer;

public class Java67_StringToInt {
	//1、功能测试：输入有+-号情况，区分正负数和0 
	//2、特殊输入：空字符串情况，输入非数字字符串情况，如a12 
	//3、边界值：最大正整数和最小负整数溢出情况
	public int StrToInt(String str) {
		//空字符串情况
		if (str.equals("") || str.length() == 0) {
			return 0;
		}
		char[] a = str.toCharArray();
		int i = 0;
		//+-符号位
		boolean symbol = true;
		if (a[0] == '-') {
			symbol = false;
			//第一位如果是-号，则从第二位开始循环
			i = 1;
		}           
		int sum = 0;
		for (; i < a.length; i++) {
			if (a[i] == '+') {
				continue;
		    }
			if (a[i] < 48 || a[i] > 57) {
		    	//有非数字字符
		        return 0;
		    }
		    sum = sum * 10 + a[i] - 48;
		    //判断是否溢出，正整数最大0X7FFF FFFF,最小负整数0X8000 0000
		    if ((symbol && sum > 0X7fffffff) || (!symbol && sum < 0X80000000)) {
		        sum = 0;
		        break;
		    }
		}
		return symbol ? sum: sum * -1;
	}
}