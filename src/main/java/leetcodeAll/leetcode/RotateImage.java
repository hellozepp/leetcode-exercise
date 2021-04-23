package leetcodeAll.leetcode;

/**
 * 48. Rotate Image
 * 
 * @author Watcher
 *
 */
public class RotateImage {

	public static void main(String[] args) {
		RotateImage so = new RotateImage();
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		so.rotate(matrix);
	}

	/**
	 * 先求转置，再逐行逆序
	 * 
	 * @param matrix
	 */
	public void rotate(int[][] matrix) {
		if (matrix.length <= 1)
			return;
		int n = matrix.length;
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				matrix[i][j] = matrix[i][j] ^ matrix[j][i];
				matrix[j][i] = matrix[i][j] ^ matrix[j][i];
				matrix[i][j] = matrix[i][j] ^ matrix[j][i];
			}
		}
		for (int i = 0; i < n; i++) {
			int lo = 0, hi = n - 1;
			while (lo < hi) {
				matrix[i][lo] = matrix[i][lo] ^ matrix[i][hi];
				matrix[i][hi] = matrix[i][lo] ^ matrix[i][hi];
				matrix[i][lo] = matrix[i][lo++] ^ matrix[i][hi--];
			}
		}
	}

	/**
	 * 直接转圈交换
	 * 
	 * @param matrix
	 */
	public void rotate2(int[][] matrix) {
		if (matrix.length <= 1)
			return;
		// 左上角和右下角的横纵坐标
		int tr = 0, tc = 0, dr = matrix.length - 1, dc = matrix.length - 1;
		while (tr < dr)
			swap(matrix, tr++, tc++, dr--, dc--);
	}

	private void swap(int[][] matrix, int tr, int tc, int dr, int dc) {
		int times = dr - tr;
		for (int i = 0; i < times; i++) {
			int tmp = matrix[tr][tc + i];
			matrix[tr][tc + i] = matrix[dr - i][tc];
			matrix[dr - i][tc] = matrix[dr][dc - i];
			matrix[dr][dc - i] = matrix[tr + i][dc];
			matrix[tr + i][dc] = tmp;
		}
	}

}
