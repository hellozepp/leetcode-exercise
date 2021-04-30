/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题12：矩阵中的路径
 * // 题目：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有
 * // 字符的路径。路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、
 * // 上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入
 * // 该格子。例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字
 * // 母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个
 * // 字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * // a b t g
 * // c f c s
 * // j d e h
 */
package offer;

public class Java12_01_StringPathInMatrix {
	/**
	 * 
	 * @param matrix 输入矩阵
	 * @param rows 矩阵行数
	 * @param cols 矩阵列数
	 * @param str 要搜索的字符串
	 * @return 是否找到，true是，false否
	 */
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		boolean visited[] = new boolean[matrix.length];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (hasPathCore(matrix, i, j, 0, rows, cols, str, visited)) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * 
	 * @param matrix 输入矩阵
	 * @param i 当前行号
	 * @param j 当前列号
	 * @param k 已处理str中字符个数
	 * @param rows 矩阵行数
	 * @param cols 矩阵列数
	 * @param str 要搜索的字符串
	 * @param visited 访问标记数组
	 * @return 是否找到，true是，false否
	 */
	public boolean hasPathCore(char[] matrix, int i, int j, int k, int rows, int cols, char[] str, boolean[] visited) {
		int index = i * cols + j;
		if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[index] != str[k] || visited[index]) {
			return false;
		}
		visited[index] = true;
		if (k == str.length - 1) {
			return true;
		}
		if (hasPathCore(matrix, i - 1, j, k + 1, rows, cols, str, visited)
			||hasPathCore(matrix, i, j - 1, k + 1, rows, cols, str, visited)
			||hasPathCore(matrix, i + 1, j, k + 1, rows, cols, str, visited)
			||hasPathCore(matrix, i, j + 1, k + 1, rows, cols, str, visited)) {
			return true;
		}
		else {
			k--;
			visited[index] = false;
		}
		return false;
	}
}
