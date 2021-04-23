package leetcodeAll.leetcode2;

/**
 * 154. Find Minimum in Rotated Sorted Array II
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin2(int[] nums) {
        int left = 0, right = nums.length - 1, mid;
        while (left <= right) {
            if (nums[left] < nums[right])
                return nums[left];
            mid = left + (right - left >> 1);
            if (nums[mid] < nums[left])
                right = mid;
            else if (nums[mid] > nums[left])
                left = mid + 1;
            else
                left++;
        }
        return nums[right];
    }
}
