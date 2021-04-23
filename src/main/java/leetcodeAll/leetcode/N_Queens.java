package leetcodeAll.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 51. N-Queens
 * 
 * @author Watcher
 *
 */
public class N_Queens {

	class Solution {
		int n;
		boolean[] col;
		boolean[] rDiag;
		boolean[] lDiag;
		char[][] board;

		/**
		 * 耗时最短的版本
		 * 
		 * @param n
		 * @return
		 */
		public List<List<String>> solveNQueens(int n) {
			List<List<String>> res = new ArrayList<>();
			this.n = n;
			col = new boolean[n];
			rDiag = new boolean[2 * n - 1];
			lDiag = new boolean[2 * n - 1];
			board = new char[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(board[i], '.');
			}

			dfs(0, res);
			return res;
		}

		public void dfs(int row, List<List<String>> res) {
			if (row == n) {
				List<String> list = new ArrayList<String>();
				for (char[] b : board) {
					list.add(new String(b));
				}
				res.add(list);
				return;
			}

			for (int i = 0; i < n; i++) {
				if (col[i] || rDiag[row + i] || lDiag[(n - 1) - (row - i)])
					continue;
				col[i] = true;
				rDiag[row + i] = true;
				lDiag[(n - 1) - (row - i)] = true;
				board[row][i] = 'Q';
				dfs(row + 1, res);
				board[row][i] = '.';
				col[i] = false;
				rDiag[row + i] = false;
				lDiag[(n - 1) - (row - i)] = false;
			}
		}
	}

	public static void main(String[] args) {
		N_Queens so = new N_Queens();
		// System.out.println(so.getStr(4, 2));
		System.out.println(so.solveNQueens3(4));
	}

	/**
	 * 修改回溯添加方式：最后再添加list。耗时3ms
	 * 
	 * @param n
	 * @return
	 */
	public List<List<String>> solveNQueens3(int n) {
		List<List<String>> res = new ArrayList<>();
		char[][] map = new char[n][n];
		for (char[] cs : map)
			Arrays.fill(cs, '.');
		solveNQueen3(res, 0, n, new boolean[n], map);
		return res;
	}

	private void solveNQueen3(List<List<String>> res, int i, int n, boolean[] cols, char[][] map) {
		if (i == n) {
			List<String> list = new ArrayList<>();
			for (char[] cs : map)
				list.add(new String(cs));
			res.add(list);
			return;
		}
		// for (int i = row; i < n; i++) { 不需要外层循环，因为每一行都必须找到一个对应位置
		for (int j = 0; j < n; j++) { // 列
			if (j == n - 1 && (cols[j] || isValid(i, j, n, map)))
				return;
			if (cols[j] || isValid(i, j, n, map)) // 当前列不可用或者对角线不可用时直接跳过
				continue;
			cols[j] = true;
			map[i][j] = 'Q';
			solveNQueen3(res, i + 1, n, cols, map);
			cols[j] = false;
			map[i][j] = '.';
		}
		// }

	}

	/**
	 * 直接做一个Q.点阵，修改检测点阵。耗时38ms(改进后耗时5ms)
	 * 
	 * @param n
	 * @return
	 */
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> res = new ArrayList<>();
		char[][] map = new char[n][n];
		for (char[] cs : map)
			Arrays.fill(cs, '.');
		solveNQueen(res, new ArrayList<String>(), 0, n, new boolean[n], map);
		return res;
	}

	private void solveNQueen(List<List<String>> res, List<String> list, int i, int n, boolean[] cols, char[][] map) {
		if (list.size() == n) {
			res.add(new ArrayList<>(list));
			return;
		}
		// for (int i = row; i < n; i++) { 不需要外层循环，因为每一行都必须找到一个对应位置
		for (int j = 0; j < n; j++) { // 列
			if (j == n - 1 && (cols[j] || isValid(i, j, n, map)))
				return;
			if (cols[j] || isValid(i, j, n, map)) // 当前列不可用或者对角线不可用时直接跳过
				continue;
			cols[j] = true;
			map[i][j] = 'Q';
			list.add(new String(map[i]));
			solveNQueen(res, list, i + 1, n, cols, map);
			cols[j] = false;
			map[i][j] = '.';
			list.remove(list.size() - 1);
		}
		// }

	}

	private boolean isValid(int row, int col, int n, char[][] map) {
		int i = row - 1, j = col - 1;
		// while (i < n && j < n)
		// if (map[i++][j++] == 'Q')
		// return true;
		// i = row - 1;
		// j = col - 1;
		while (i >= 0 && j >= 0)
			if (map[i--][j--] == 'Q')
				return true;
		i = row - 1;
		j = col + 1;
		while (i >= 0 && j < n)
			if (map[i--][j++] == 'Q')
				return true;
		// i = row + 1;
		// j = col - 1;
		// while (i < n && j >= 0)
		// if (map[i++][j--] == 'Q')
		// return true;
		return false;
	}

	/**
	 * 回溯法直接实现，耗时较长，152ms(将字符串拼接改为数组组成字符串后125ms)(去掉外层循环后耗时6ms)
	 * 
	 * @param n
	 * @return
	 */
	public List<List<String>> solveNQueens2(int n) {
		List<List<String>> res = new ArrayList<>();
		solve(res, new ArrayList<String>(), 0, n, new boolean[n], new boolean[n][n]);
		return res;
	}

	private void solve(List<List<String>> res, List<String> list, int i, int n, boolean[] cols, boolean[][] state) {
		if (list.size() == n) {
			res.add(new ArrayList<>(list));
			return;
		}
		// for (int i = row; i < n; i++) { // 不需要外层循环，因为每一行都必须找到一个对应位置
		for (int j = 0; j < n; j++) { // 列
			if (j == n - 1 && (cols[j] || isDiag(i, j, n, state))) // 当第i行找不到一个有效位置，直接结束函数
				return;
			if (cols[j] || isDiag(i, j, n, state)) // 当前列不可用或者对角线不可用时直接跳过
				continue;
			list.add(getStr(n, j));
			cols[j] = true;
			state[i][j] = true;
			solve(res, list, i + 1, n, cols, state);
			list.remove(list.size() - 1);
			cols[j] = false;
			state[i][j] = false;
		}
		// }
	}

	/**
	 * 检测 state中(i,j)位置的对角线上是否有true
	 * 
	 * @param i
	 * @param j
	 * @param state
	 * @return
	 */
	private boolean isDiag(int row, int col, int n, boolean[][] state) {
		int i = row, j = col;
		while (i < n && j < n)
			if (state[i++][j++])
				return true;
		i = row - 1;
		j = col - 1;
		while (i >= 0 && j >= 0)
			if (state[i--][j--])
				return true;
		i = row - 1;
		j = col + 1;
		while (i >= 0 && j < n)
			if (state[i--][j++])
				return true;
		i = row + 1;
		j = col - 1;
		while (i < n && j >= 0)
			if (state[i++][j--])
				return true;
		return false;
	}

	/**
	 * 返回长度为n的字符串，下标为i的字符为Q，其余为.
	 * 
	 * @param n
	 * @param i
	 * @return
	 */
	private String getStr(int n, int i) {
		// StringBuilder sb = new StringBuilder();
		// for (int j = 0; j < n; j++) {
		// sb.append('.');
		// }
		// sb.replace(i, i + 1, "Q");
		// return sb.toString();
		char[] arr = new char[n];
		Arrays.fill(arr, '.');
		arr[i] = 'Q';
		return new String(arr);
	}

}
