package leetcodeAll.leetcode;

/**
 * 59. Spiral Matrix II
 * 
 * @author Watcher
 *
 */
public class SpiralMatrixII {
	public int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		spiral(1, res, 0, 0, n - 1, n - 1);
		return res;
	}

	private void spiral(int cur, int[][] res, int tr, int tc, int dr, int dc) {
		if (tr > dr || tc > dc)
			return;
		if (tr == dr) { // 只有一行
			for (int i = tc; i <= dc; i++)
				res[tr][i] = cur++;
			return;
		}
		if (tc == dc) { // 只有一列
			for (int i = tr; i <= dr; i++)
				res[i][tc] = cur++;
			return;
		}
		for (int i = tc; i < dc; i++)
			res[tr][i] = cur++;
		for (int i = tr; i < dr; i++)
			res[i][dc] = cur++;
		for (int i = dc; i > tc; i--)
			res[dr][i] = cur++;
		for (int i = dr; i > tr; i--)
			res[i][tc] = cur++;
		spiral(cur, res, tr + 1, tc + 1, dr - 1, dc - 1);
	}
}
