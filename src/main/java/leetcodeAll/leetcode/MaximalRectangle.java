package leetcodeAll.leetcode;

import java.util.Arrays;

/**
 * 85. Maximal Rectangle
 * 
 * @author Watcher
 *
 */
public class MaximalRectangle {
	public static void main(String[] args) {
		char[][] matrix = { { '1', '1', '1', '0' }, { '1', '1', '0', '0' }, { '1', '1', '1', '1' }, { '1', '1', '1', '0' } };
		System.out.println(new MaximalRectangle().maximalRectangle(matrix));
	}

	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int res = 0, m = matrix.length, n = matrix[0].length;
		int[] heights = new int[n]; // 当前列1的连续高度
		for (int i = 0; i < m; i++) {
			getHeight(matrix[i], heights);
			res = Math.max(res, largestRectangleArea(Arrays.copyOf(heights, heights.length)));
		}
		return res;
	}

	private void getHeight(char[] matrix, int[] heights) {
		for (int i = 0; i < matrix.length; i++)
			if (matrix[i] == '0')
				heights[i] = 0;
			else
				heights[i]++;
	}

	public int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0)
			return 0;
		int start = 0, res = 0;
		for (int i = 0; i < heights.length; i++)
			if (heights[i] != 0) { // 确保start为最小的非零下标
				start = i;
				break;
			}
		res = heights[start];
		for (int i = start + 1; i < heights.length; i++) {
			if (heights[i] == 0) { // 每次遇到0，更新最大值，且更新start
				res = getMax(heights, start, i - 1, res);
				start = i + 1;
			} else if (heights[i] < heights[i - 1]) {
				res = getMax(heights, start, i - 1, res);
				for (int j = i - 1; j >= start && heights[j] > heights[i]; j--)
					heights[j] = heights[i];
			}
		}
		res = getMax(heights, start, heights.length - 1, res);
		return res;
	}

	private int getMax(int[] heights, int start, int index, int res) {
		for (int i = index; i >= start; i--)
			res = Math.max(res, heights[i] * (index - i + 1));
		return res;
	}
}
