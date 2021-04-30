package suanfa.leetcode;

/**
 * 给定一个整型数组和一个数字s，找到数组中最短的一个连续子数组，使得连续子数组的数字和sum >= s，返回这个最短的连续子数组的长度值
 * 如，给定数组[2, 3, 1, 2, 4, 3], s = 7
 * 答案为[4, 3]，返回2
 */
public class a209MinimumSizeSubarraySum {
    //    滑动窗口的思路
    public int solution2(int[] arr, int s) {
        int l = 0, r = 0, res = 0, sum = 0;
        while (l < arr.length) {
            if (sum < s && r < arr.length) {
                sum += arr[r++];
            } else {
                sum -= arr[l++];
            }
            if (sum >= s) {
                res = Math.min(res, r - l + 1);
            }
        }
        return res;
    }

    //    暴力解法
    public int solution1(int[] arr, int s) {
        int res = arr.length + 1;
        for (int l = 0; l < arr.length; l++) {
            for (int r = l; r < arr.length; r++) {
                int sum = 0;
                for (int k = l; k <= r; k++) {//循环次数为 n*n*(0+n-1)/2 ~= 3n 【（首项+末项）*项数】÷2
                    sum += arr[k];
                }
                if (sum >= s) {
                    res = Math.min(res, r - l + 1);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int nums[] = {2, 3, 1, 2, 4, 3, 7};
        int s = 7;
        System.out.println(new a209MinimumSizeSubarraySum().solution2(nums, s));
        ;
    }
}
