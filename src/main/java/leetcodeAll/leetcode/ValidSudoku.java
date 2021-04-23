package leetcodeAll.leetcode;

import java.util.HashSet;

/**
 * 36. Valid Sudoku
 * 
 * @author Watcher
 *
 */
public class ValidSudoku {

	/**
	 * 利用一维数组中每一位数的二进制来记录状态
	 * 
	 * @param board
	 * @return
	 */
	public boolean isValidSudoku(char[][] board) {
		int[] rows = new int[9];
		int[] cols = new int[9];
		int[] blocks = new int[9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.')
					continue;
				int value = 1 << (board[i][j] - '0');
				if ((value & rows[i]) != 0)
					return false;
				if ((value & cols[j]) != 0)
					return false;
				if ((value & blocks[3 * (i / 3) + j / 3]) != 0)
					return false;
				rows[i] |= value;
				cols[j] |= value;
				blocks[3 * (i / 3) + j / 3] |= value;
			}
		}
		return true;
	}

	/**
	 * 用set和String拼接实现，简单易懂。
	 * 
	 * @param board
	 * @return
	 */
	public boolean isValidSudoku2(char[][] board) {
		HashSet<String> set = new HashSet<String>();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				char cur = board[i][j];
				if (cur != '.')
					if (!set.add(cur + "in row" + i) || !set.add(cur + "in column" + j) || !set.add(cur + "in block" + i / 3 + j / 3))
						return false;
			}
		}
		return true;
	}
}
