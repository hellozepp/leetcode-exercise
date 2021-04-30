/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题4：二维数组中的查找
 * // 题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按
 * // 照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个
 * // 整数，判断数组中是否含有该整数。
 */
package offer;

public class Java04_FindInPartiallySortedMatrix {
    public static boolean Find(int [][] array, int number) {
    	//从二维数组的右上角开始选取与target比较的整数
    	//column的变化：array[0].length - 1 --> 0
    	//row的变化：0 --> array.length - 1
    	if (array == null) {
    		return false;
    	}
    	int column = array[0].length - 1;
    	int row = 0;
    	while (row < array.length && column >= 0) {
    		if (array[row][column] == number) {
    			return true;
    		}
    		if (array[row][column] > number) {
    			column--;
    		}
    		else {
    			row++;
    		}
    	}
    	return false;
    }
    
    public static void main(String[] args) {
    	/*
    	 * 1 2 8 9
    	 * 2 4 9 12
    	 * 4 7 10 13
    	 * 6 8 11 15
    	 */
    	int[][] testArray = new int[4][4];
    	testArray[0][0] = 1;
    	testArray[0][1] = 2;
    	testArray[0][2] = 8;
    	testArray[0][3] = 9;
    	testArray[1][0] = 2;
    	testArray[1][1] = 4;
    	testArray[1][2] = 9;
    	testArray[1][3] = 12;
    	testArray[2][0] = 4;
    	testArray[2][1] = 7;
    	testArray[2][2] = 10;
    	testArray[2][3] = 13;
    	testArray[3][0] = 6;
    	testArray[3][1] = 8;
    	testArray[3][2] = 11;
    	testArray[3][3] = 15;
    	System.out.println(Find(testArray, 1));
    	System.out.println(Find(testArray, 7));
	}
}
