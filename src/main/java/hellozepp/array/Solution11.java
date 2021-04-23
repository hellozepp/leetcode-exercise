package hellozepp.array;


/**
 * 求容器最大面积 滑动窗口
 * 给定 n 个非负整数 a1，a2，…，an，每个数代表坐标中的一个点 (i, ai) 。画 n 条垂直线，使得垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * **注意：**你不能倾斜容器，n 至少是2。
 * 垂直线代表输入数组 [1,8,6,2,5,4,8,3,7] 最大值为 49。
 *
 * 难度2星
 */
public class Solution11 {
    public int maxArea(int[] height) {

        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) { //n>=2
            maxArea = Math.max(maxArea, Math.min(height[left], height[right]) * (right - left));//最小边*宽度
            if (height[left] < height[right])
                left++;
            else
                right--;
        }

        return maxArea;
    }
}