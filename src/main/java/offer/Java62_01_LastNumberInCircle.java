/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题62：圆圈中最后剩下的数字
 * // 题目：0, 1, …, n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里
 * // 删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 */
package offer;

public class Java62_01_LastNumberInCircle {
	/** 方法一：数组O(m*N) */
	public int LastRemaining_Solution(int n, int m) {
		if (n < 1 || m < 1) {
			return -1;
		}
		int[] array = new int[n];
		int i = -1, step = 0, count = n;
		//跳出循环时将最后一个元素也设置为了-1
		while (count > 0) {
			//指向上一个被删除对象的下一个元素
		    i++;
		    //模拟环
		    if (i >= n) {
		    	i=0;  
		    }
		    //跳过被删除的对象
		    if(array[i] == -1) {
		    	continue; 
		    }
		    //记录已走过的
		    step++;           
		    //找到待删除的对象
		    if (step == m) {               
		        array[i] =- 1;
		        step = 0;
		        count--;
		    }        
		}
		//返回跳出循环时的i,即最后一个被设置为-1的元素
		return i;
	}
}