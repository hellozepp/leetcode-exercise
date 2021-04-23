package leetcodeAll.leetcode2;

/**
 * 153. Find Minimum in Rotated Sorted Array
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        return help(nums, 0, nums.length - 1);
    }

    private int help(int[] nums, int left, int right) {
        if (nums[left] <= nums[right])
            return nums[left];
        int mid = left + (right - left >> 1);
        if (nums[mid] < nums[left])
            return help(nums, left, mid);
        return help(nums, mid + 1, right);
    }

    /**
     * 迭代版
     *
     * @param nums
     * @return
     */
    public int findMin2(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            if (nums[left] <= nums[right])
                return nums[left];
            mid = left + (right - left >> 1);
            if (nums[mid] < nums[left])
                right = mid;
            else
                left = mid + 1;
        }
        return -1;
    }
}
