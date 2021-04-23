package leetcodeAll.leetcode;

/**
 * 74. Search a 2D Matrix
 * 
 * @author Watcher
 *
 */
public class Searcha2DMatrix {
	public boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0 || target < matrix[0][0] || target > matrix[matrix.length - 1][matrix[0].length - 1])
			return false;
		int row = matrix.length - 1, col = 0;
		while (row >= 0 && col < matrix[0].length) {
			if (matrix[row][col] > target)
				row--;
			else if (matrix[row][col] < target)
				col++;
			else
				return true;
		}
		return false;
	}
}
