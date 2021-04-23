package leetcodeAll.leetcode9;

/**
 * 867. Transpose Matrix
 * 
 * Given a matrix A, return the transpose of A.
 * 
 * The transpose of a matrix is the matrix flipped over it's main diagonal, switching the row and
 * column indices of the matrix.
 * 
 * @author Watcher
 *
 */
public class TransposeMatrix {

	/**
	 * 二维数组的转置
	 * 
	 * @param A
	 * @return
	 */
	public int[][] transpose(int[][] A) {
		int m = A.length, n = A[0].length; // m*n 转换为n*m
		int[][] res = new int[n][m];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				res[j][i] = A[i][j];
			}
		}
		return res;

	}
}
