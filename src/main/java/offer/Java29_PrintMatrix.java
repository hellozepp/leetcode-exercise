/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题29：顺时针打印矩阵
 * // 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 */
package offer;
import java.util.ArrayList;

public class Java29_PrintMatrix {
	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		int rows = matrix.length;
		int columns = matrix[0].length;
		if(matrix == null || columns <= 0 || rows <= 0){
		     return null;
		}
		int start = 0;
		while(columns > start * 2 && rows > start * 2){
			print1Circle(list, matrix, columns, rows, start);
			start++;
		 }
		return list;
	 }
	
	public void print1Circle(ArrayList<Integer> list, int[][] matrix, int columns, int rows, int start) {
		int endX = columns - 1 - start;
		int endY = rows - 1 - start;
	
	    //从左往右打印一行
		for (int i = start; i <= endX; i++) {
			list.add(matrix[start][i]);
	     }
	
	    //从上往下打印一列，至少有两行
		if (start < endY){
			for (int i = start + 1; i <= endY; i++) {
				list.add(matrix[i][endX]);
	         }
	     }
	
	     //从右往左打印一行，至少有两行两列
	     if (start < endY && start < endX){
	    	 for (int i = endX - 1; i >= start; i--) {
	    		 list.add(matrix[endY][i]);
	         }
	     }
	
	     //从下往上打印一列，至少有三行两列
	     if (start < endY - 1 && start < endX){
	    	 for (int i = endY - 1; i >= start + 1; i--) {
	    		 list.add(matrix[i][start]);
	         }
	     }
	 }
 }