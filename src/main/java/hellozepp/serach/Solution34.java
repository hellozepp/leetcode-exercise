package hellozepp.serach;


/**
 * 给定一个按照升序排列的整数数组 nums，
 * 和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 算法复杂度 不超过 O(logN)
 *
 * 难度1星
 *
 */
public class Solution34 {
    public int[] searchRange(int[] nums, int target) {


        int start = -1;
        int end = -1;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == target) {
                if (start == -1) {
                    start = i;
                }
                if (end < i) {
                    end = i;
                }

            }
        }

        return new int[]{start, end};

    }

    public int[] searchRange1(int[] nums, int target) {
        int l = 0, r = nums.length;
        int mid = (l + r) / 2;
        int p = -1;
        while (l < r) {
            if (nums[mid] == target) {
                p = mid;
                break;
            }
            if (nums[mid] > target) {
                if (r == mid) {
                    break;
                }
                r = mid;
                mid = (l + r) / 2;
            } else {
                if (l == mid) {
                    break;
                }
                l = mid;
                mid = (l + r) / 2;
            }
        }//end while
        if (p == -1) {
            return new int[]{-1, -1};
        } else {
            int a = p, b = p;
            while (a > 0 && nums[a - 1] == target) a--;
            while (b < nums.length - 1 && nums[b + 1] == target) b++;
            return new int[]{a, b};
        }
    }
}