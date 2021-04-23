package leetcodeAll.leetcode;

/**
 * 42. Trapping Rain Water
 *
 * @author Watcher
 */
public class TrappingRainWater {

    /**
     * 双指针精简版，耗时13ms
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1, maxHeight = 0; // 左右边界下标，左右最高柱子
        while (left < right) {
            int lower = height[left] <= height[right] ? left++ : right--;
            maxHeight = Math.max(maxHeight, height[lower]);
            res += maxHeight - height[lower];
        }
        return res;
    }

    /**
     * 双指针，耗时12ms
     *
     * @param height
     * @return
     */
    public int trap2(int[] height) {
        int res = 0;
        int left = 0, right = height.length - 1, maxLeft = 0, maxRight = 0; // 左右边界下标，左右最高柱子
        while (left < right) {
            if (height[left] <= height[right]) { // 左边界更短，左边有效
                if (height[left] >= maxLeft)
                    maxLeft = height[left];
                else
                    res += maxLeft - height[left];
                left++;
            } else {
                if (height[right] >= maxRight)
                    maxRight = height[right];
                else
                    res += maxRight - height[right];
                right--;
            }
        }
        return res;
    }

    /**
     * 削减高度，计算法，耗时16ms
     *
     * @param height
     * @return
     */
    public int trap3(int[] height) {
        int res = 0;
        int[] edge = getEdge(height); // 获得非零左右边界下标
        while (edge != null) {
            res += getWater(height, edge); // 左右边界之间的水量
            edge = getEdge(height); // 重算边界
        }
        return res;
    }

    private int getWater(int[] height, int[] edge) {
        int validEdge = height[edge[0]] <= height[edge[1]] ? height[edge[0]] : height[edge[1]]; // 左右边界中较短的边界的高度
        height[edge[0]] -= validEdge; // 削减左边界
        height[edge[1]] -= validEdge; // 削减右边界
        int res = (edge[1] - edge[0] - 1) * validEdge;
        for (int i = edge[0] + 1; i < edge[1]; i++) {
            if (height[i] > validEdge) {
                res -= validEdge;
                height[i] -= validEdge;
            } else {
                res -= height[i];
                height[i] = 0;
            }
        }
        return res;
    }

    private int[] getEdge(int[] height) {
        int[] edge = new int[2];
        for (int i = 0; i < height.length; i++) // 左边界
            if (height[i] > 0) {
                edge[0] = i;
                break;
            }
        for (int i = height.length - 1; i >= edge[0]; i--) // 右边界
            if (height[i] > 0) {
                edge[1] = i;
                break;
            }
        if (edge[1] - edge[0] > 1)
            return edge;
        return null;
    }

    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 1, 1};
        System.out.println(new TrappingRainWater().trap(height));
    }
}
