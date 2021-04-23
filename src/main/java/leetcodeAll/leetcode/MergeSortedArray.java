package leetcodeAll.leetcode;

/**
 * 88. Merge Sorted Array
 * 
 * @author Watcher
 *
 */
public class MergeSortedArray {

	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int index = m-- + --n;
		while (m >= 0 && n >= 0)
			nums1[index--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
		while (n >= 0)
			nums1[index--] = nums2[n--];
	}

	public void merge2(int[] nums1, int m, int[] nums2, int n) {
		int[] help = new int[m + n];
		int i = 0, j = 0, k = 0;
		while (i < m && j < n)
			help[k++] = nums1[i] <= nums2[j] ? nums1[i++] : nums2[j++];
		while (i < m)
			help[k++] = nums1[i++];
		while (j < n)
			help[k++] = nums2[j++];
		i = 0;
		while (i < m + n)
			nums1[i] = help[i++];
	}
}
