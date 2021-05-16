package hellozepp.dp;


/**
 * 找出最长递增 子序列
 * <p>
 *     [1,3,2,3,1,4] 返回 [1,2,3,4]
 * 难度2星
 * n^2复杂度为medium nlogn为hard
 */
public class Solution300 {
    /**
     * 贪心加二分查找，每次跟栈中最后一个比较，大的话放进去，小的话二分查找一个大于等于当前值的做替换，保证栈中子序列的值是局部最小的
     * @param nums
     * @return
     */
    public int lengthOfLIS2(int[] nums) {
        int len = nums.length;
        if (len < 1) {
            return 0;
        }
        int[] d = new int[len];
        int end = 0;  //记录序列当前最长长度
        d[0] = nums[0];  //初始长度为1，这里以i+1表示长度
        for (int i = 1; i < len; i++) {
            if (nums[i] > d[end]) {
                d[end + 1] = nums[i];
                end++;   //如果找到大的数值，延长序列
            } else {
                int index = biSearch(d, end, nums[i]);  //二分查找
                d[index + 1] = nums[i];
            }
        }
        return end + 1;  //长度是i+1
    }

    public int biSearch(int[] nums, int end, int n) {
        int begin = 0;
        int mid = 0;
        if (n <= nums[0]) {
            return -1;  //如果查找的值比最小值还小，返回-1，更新下标0处数值
        }
        while (begin < end) {
            mid = (begin + end + 1) / 2;
            if (nums[mid] >= n) {
                end = mid - 1;
            } else if (nums[mid] < n) {
                begin = mid;
            }
        }
        return end;
    }

    //--------------------------------
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(dp[i], max);
        }

        return max;
    }
}