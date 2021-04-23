package leetcodeAll.leetcode;

/**
 * 33. Search in Rotated Sorted Array
 * 
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its index, otherwise return
 * -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * @author Watcher
 *
 */
public class SearchInRotatedSortedArray {
	public static void main(String[] args) {
		SearchInRotatedSortedArray so = new SearchInRotatedSortedArray();
		int[] nums = { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(so.search(nums, 0));
	}

	/**
	 * 非递归版
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int lo = 0, hi = nums.length - 1;
		while (lo < hi) {
			int mid = lo + ((hi - lo) >> 1);
			if (nums[mid] == target)
				return mid;
			else if (nums[mid] < nums[hi]) { // 反转点在中点左边
				if (nums[mid] < target && nums[hi] >= target) // target只可能在mid右边
					lo = mid + 1;
				else
					hi = mid - 1;
			} else { // 反转点在中点右边
				if (nums[mid] > target && nums[lo] <= target) // target只可能在mid左边
					hi = mid - 1;
				else
					lo = mid + 1;
			}
		}
		return nums[lo] == target ? lo : -1;
	}

	/**
	 * 递归版
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int search2(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		if (nums.length == 1) {
			return nums[0] == target ? 0 : -1;
		}
		int index = searchIndex(nums, 0, nums.length - 1, target);

		return index;
	}

	private int searchIndex(int[] nums, int lo, int hi, int target) {
		if (lo > hi)
			return -1;
		if (lo == hi) {
			return target == nums[hi] ? hi : -1;
		}
		int mid = lo + ((hi - lo) >> 1);
		if (nums[mid] == target) {
			return mid;
		} else if (nums[mid] < nums[hi]) { // 反转点在中点左边
			if (nums[mid] < target && nums[hi] >= target) { // target只可能在mid右边
				return searchIndex(nums, mid + 1, hi, target);
			} else { // target只可能在mid左边
				return searchIndex(nums, lo, mid - 1, target);
			}
		} else { // 反转点在中点右边
			if (nums[mid] > target && nums[lo] <= target) // target只可能在mid左边
				return searchIndex(nums, lo, mid - 1, target);
			else
				return searchIndex(nums, mid + 1, hi, target);
		}
	}
}
