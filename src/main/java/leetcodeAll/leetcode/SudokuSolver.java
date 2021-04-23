package leetcodeAll.leetcode;

/**
 * 37. Sudoku Solver
 * 
 * @author Watcher
 *
 */
public class SudokuSolver {

	public void solveSudoku(char[][] board) {
		boolean[][] rows = new boolean[9][9];
		boolean[][] cols = new boolean[9][9];
		boolean[][] blocks = new boolean[9][9];
		int count = buildMap(board, rows, cols, blocks);
		if (count > 0)
			solve(board, rows, cols, blocks, 0);
	}

	private boolean solve(char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] blocks, int index) {
		if (index == 81)
			return true;
		int row = index / 9;
		int col = index % 9;
		if (board[row][col] != '.')
			return solve(board, rows, cols, blocks, index + 1);
		for (int i = 0; i < 9; i++) {
			if (!rows[row][i] && !cols[col][i] && !blocks[3 * (row / 3) + col / 3][i]) {
				board[row][col] = (char) (i + '1');
				rows[row][i] = true;
				cols[col][i] = true;
				blocks[3 * (row / 3) + col / 3][i] = true;
				if (solve(board, rows, cols, blocks, index + 1))
					return true;
				board[row][col] = '.';
				rows[row][i] = false;
				cols[col][i] = false;
				blocks[3 * (row / 3) + col / 3][i] = false;
			}
		}
		return false;
	}

	private int buildMap(char[][] board, boolean[][] rows, boolean[][] cols, boolean[][] blocks) {
		int count = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					count++;
					int index = board[i][j] - '1';
					rows[i][index] = true;
					cols[j][index] = true;
					blocks[3 * (i / 3) + j / 3][index] = true;
				}
			}
		}
		return count;
	}
}
