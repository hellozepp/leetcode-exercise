package leetcodeAll.leetcode;

/**
 * 81. Search in Rotated Sorted Array II
 * 
 * @author Watcher
 *
 */
public class SearchInRotatedSortedArrayII {

	public boolean search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return false;
		int lo = 0, hi = nums.length - 1;
		while (lo < hi) {
			int mid = lo + ((hi - lo) >> 1);
			if (nums[mid] == target)
				return true;
			else if (nums[mid] < nums[hi]) { // 反转点在中点左边
				if (nums[mid] < target && nums[hi] >= target) // target只可能在mid右边
					lo = mid + 1;
				else
					hi = mid - 1;
			} else if (nums[mid] > nums[hi]) { // 反转点在中点右边
				if (nums[mid] > target && nums[lo] <= target) // target只可能在mid左边
					hi = mid - 1;
				else
					lo = mid + 1;
			} else {
				hi--;
			}
		}
		return nums[lo] == target ? true : false;
	}

	public boolean search2(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return false;
		if (nums.length == 1) {
			return nums[0] == target ? true : false;
		}
		return searchIndex(nums, 0, nums.length - 1, target);
	}

	private boolean searchIndex(int[] nums, int lo, int hi, int target) {
		if (lo > hi)
			return false;
		int mid = lo + ((hi - lo) >> 1);
		if (nums[mid] == target) {
			return true;
		} else if (nums[mid] == nums[lo]) {
			return searchIndex(nums, lo + 1, mid - 1, target) || searchIndex(nums, mid + 1, hi, target);
		} else if (nums[mid] == nums[hi]) {
			return searchIndex(nums, lo, mid - 1, target) || searchIndex(nums, mid + 1, hi - 1, target);
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
