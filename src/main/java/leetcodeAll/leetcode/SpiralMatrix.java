package leetcodeAll.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. Spiral Matrix
 * 
 * @author Watcher
 *
 */
public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<Integer>();
		if (matrix.length > 0 && matrix[0].length > 0)
			spiral(list, matrix, 0, 0, matrix.length - 1, matrix[0].length - 1);
		return list;
	}

	private void spiral(List<Integer> list, int[][] matrix, int tr, int tc, int dr, int dc) {
		if (tr > dr || tc > dc)
			return;
		if (tr == dr) { // 只有一行
			for (int i = tc; i <= dc; i++)
				list.add(matrix[tr][i]);
			return;
		}
		if (tc == dc) { // 只有一列
			for (int i = tr; i <= dr; i++)
				list.add(matrix[i][tc]);
			return;
		}
		for (int i = tc; i < dc; i++)
			list.add(matrix[tr][i]);
		for (int i = tr; i < dr; i++)
			list.add(matrix[i][dc]);
		for (int i = dc; i > tc; i--)
			list.add(matrix[dr][i]);
		for (int i = dr; i > tr; i--)
			list.add(matrix[i][tc]);
		spiral(list, matrix, tr + 1, tc + 1, dr - 1, dc - 1);
	}
}
