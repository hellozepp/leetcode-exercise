package leetcodeAll.leetcode;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 * 
 * Given an array of integers nums sorted in ascending order, find the starting and ending position
 * of a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * @author Watcher
 *
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

	public int[] searchRange(int[] nums, int target) {
		int index = searchIndex(nums, target);
		if (index == -1)
			return new int[] { -1, -1 };
		int lo = searchLow(nums, index);
		int hi = searchHigh(nums, index);
		return new int[] { lo, hi };
	}

	private int searchHigh(int[] nums, int lo) {
		int hi = nums.length - 1, target = nums[lo];
		while (lo <= hi) {
			int mid = lo + ((hi - lo) >> 1);
			if (nums[mid] == target)
				lo = mid + 1;
			else
				hi = mid - 1;
		}
		return lo - 1;
	}

	private int searchLow(int[] nums, int hi) {
		int lo = 0, target = nums[hi];
		while (lo <= hi) {
			int mid = lo + ((hi - lo) >> 1);
			if (nums[mid] == target)
				hi = mid - 1;
			else
				lo = mid + 1;
		}
		return hi + 1;
	}

	/**
	 * 二分查找target
	 * 
	 * @param nums
	 * @param lo
	 * @param hi
	 * @param target
	 * @return
	 */
	private int searchIndex(int[] nums, int target) {
		int lo = 0, hi = nums.length - 1;
		while (lo <= hi) {
			int mid = lo + ((hi - lo) >> 1);
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] > target)
				hi = mid - 1;
			else
				lo = mid + 1;
		}
		return -1;
	}
}
