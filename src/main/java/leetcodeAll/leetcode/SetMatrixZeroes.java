package leetcodeAll.leetcode;

/**
 * 73. Set Matrix Zeroes
 * 
 * @author Watcher
 *
 */
public class SetMatrixZeroes {

	public static void main(String[] args) {
		SetMatrixZeroes so = new SetMatrixZeroes();
		int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		so.setZeroes(matrix);
	}

	public void setZeroes(int[][] matrix) {
		int row = matrix.length, col = matrix[0].length;
		boolean r = false, c = false;
		for (int i = 0; i < row; i++) // 判断第一列是否有0
			if (matrix[i][0] == 0) {
				r = true;
				break;
			}
		for (int j = 0; j < col; j++) // 判断第一行是否有0
			if (matrix[0][j] == 0) {
				c = true;
				break;
			}
		for (int i = 1; i < row; i++)
			for (int j = 1; j < col; j++) {
				if (matrix[i][j] == 0)
					matrix[0][j] = matrix[i][0] = 0;
			}
		for (int i = 1; i < row; i++)
			if (matrix[i][0] == 0) {
				for (int j = 1; j < col; j++)
					matrix[i][j] = 0;
			}
		for (int j = 1; j < col; j++)
			if (matrix[0][j] == 0) {
				for (int i = 1; i < row; i++)
					matrix[i][j] = 0;
			}
		if (r)
			for (int i = 0; i < row; i++)
				matrix[i][0] = 0;
		if (c)
			for (int j = 0; j < col; j++)
				matrix[0][j] = 0;
	}

	public void setZeroes2(int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
		boolean[] cols = new boolean[n];
		for (int i = 0; i < matrix.length; i++) {
			boolean flag = false;
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					cols[j] = true;
					flag = true;
				}
			}
			if (flag)
				change(matrix, i);
		}
		for (int i = 0; i < n; i++) {
			if (cols[i]) {
				for (int j = 0; j < m; j++)
					matrix[j][i] = 0;
			}
		}
	}

	private void change(int[][] matrix, int i) {
		for (int j = 0; j < matrix[0].length; j++)
			matrix[i][j] = 0;
	}

}
