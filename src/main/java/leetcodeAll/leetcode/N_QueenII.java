package leetcodeAll.leetcode;

/**
 * 52. N-Queens II
 * 
 * @author Watcher
 *
 */
public class N_QueenII {
	public int totalNQueens(int n) {
		int res = 0;
		boolean[] cols = new boolean[n], rDiag = new boolean[2 * n - 1], cDiag = new boolean[2 * n - 1];
		return countQueens(res, 0, n, cols, rDiag, cDiag);
	}

	private int countQueens(int res, int row, int n, boolean[] cols, boolean[] rDiag, boolean[] cDiag) {
		if (row == n)
			return ++res;
		for (int col = 0; col < n; col++) {
			if (cols[col] || rDiag[row + col] || cDiag[n - 1 + col - row])
				continue;
			cols[col] = true;
			rDiag[row + col] = true;
			cDiag[n - 1 + col - row] = true;
			res = countQueens(res, row + 1, n, cols, rDiag, cDiag);
			cols[col] = false;
			rDiag[row + col] = false;
			cDiag[n - 1 + col - row] = false;
		}
		return res;
	}
}
