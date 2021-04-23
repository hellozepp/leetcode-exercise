package leetcodeAll.leetcode;

import java.util.Stack;

/**
 * 84. Largest Rectangle in Histogram
 *
 * @author Watcher
 */
public class LargestRectangleInHistogram {

    /**
     * 单调栈解法
     *
     * @param heights
     * @return
     */
    public int largestRectangleAreaByStack(int[] heights) {
        if (heights == null || heights.length == 0)
            return 0;
        Stack<Integer> stack = new Stack<>();
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i])
                maxArea = Math.max(maxArea, heights[stack.pop()] * (i - (stack.isEmpty() ? -1 : stack.peek()) - 1));
            stack.push(i);
        }
        while (!stack.isEmpty())
            maxArea = Math.max(maxArea, heights[stack.pop()] * (heights.length - (stack.isEmpty() ? -1 : stack.peek()) - 1));
        return maxArea;
    }

    /**
     * 在原数组上修改，保证数组是非递减的，模仿栈；耗时2ms
     *
     * @param heights
     * @return
     */
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

    /**
     * 暴力求解，耗时524ms
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea2(int[] heights) {
        int start = 0, max = 0;
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] == 0)
                start = i + 1;
            else
                max = Math.max(max, largest(heights, start, i));
        }
        return max;
    }

    private int largest(int[] heights, int start, int index) {
        int min = heights[index], max = heights[index];
        for (int i = index - 1; i >= start; i--) {
            min = Math.min(min, heights[i]);
            max = Math.max(max, min * (index - i + 1));
        }
        return max;
    }
}
