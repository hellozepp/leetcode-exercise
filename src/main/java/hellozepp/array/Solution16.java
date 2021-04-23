package hellozepp.array;

import java.util.Arrays;

/**
 * 从 nums找出三个数时　ａ＋ｂ＋ｃ　最接近target
 * <p>
 * 返回三个数的和
 * For example, given array S = {-1 2 1 -4}, and target = 1.
 * 难度2星
 */
public class Solution16 {
    public int threeSumClosest(int[] num, int target) {

        Arrays.sort(num); //先排序
        int min = num[0] + num[1] + num[2];
        // 设置 3个点
        for (int i = 0; i < num.length - 2; i++) {
            int start = i + 1;
            int end = num.length - 1;
            while (start < end) {
                int sum = num[i] + num[start] + num[end];

                if (sum > target) end--;
                else start++;

                if (Math.abs(target - sum) < Math.abs(target - min)) min = sum;
            }
        }
        return min;
    }
}