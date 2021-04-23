package leetcodeAll.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * * 4. Median of Two Sorted Arrays
 * 
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * @author Watcher
 *
 */
public class MedianOfTwoSortedArrays {

	/**
	 * 二分查找
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int m = nums1.length, n = nums2.length;
		int left = (m + n + 1) / 2, right = (n + m + 2) / 2; // 下中位数和上中位数
		return (findKth(nums1, nums2, left) + findKth(nums1, nums2, right)) / 2.0;
	}

	private int findKth(int[] nums1, int[] nums2, int k) {
		int m = nums1.length, n = nums2.length;
		if (m > n)
			return findKth(nums2, nums1, k);
		if (m == 0)
			return nums2[k - 1];
		if (k == 1)
			return Math.min(nums1[0], nums2[0]);
		int i = Math.min(m, k / 2), j = Math.min(n, k / 2);
		if (nums1[i - 1] > nums2[j - 1])
			return findKth(nums1, Arrays.copyOfRange(nums2, j, n), k - j);
		else
			return findKth(Arrays.copyOfRange(nums1, i, m), nums2, k - i);
	}

	/**
	 * 用堆实现，时间复杂度为O(nlogn) 不符合题目要求
	 * 
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public double findMedianSortedArrays2(int[] nums1, int[] nums2) {

		// 利用PriorityQueue建立大根堆和小根堆
		PriorityQueue<Integer> min = new PriorityQueue<Integer>();
		PriorityQueue<Integer> max = new PriorityQueue<Integer>(10, new Comparator<Integer>() {
			@Override
			public int compare(Integer num1, Integer num2) {
				// TODO Auto-generated method stub
				return num2 - num1;
			}
		});
		boolean flag = true; // 第偶数个数进小根堆，第奇数个数进大根堆，true 表示第奇数个数

		for (int i = 0; i < nums1.length; i++) {
			int num = nums1[i];
			if (flag) {// 第奇数个数，进小根堆（先进大根堆，再进小根堆）
				max.offer(num);
				min.offer(max.poll());
				flag = !flag;
			} else {// 第偶数个数，进大根堆（先进小根堆，再进大根堆）
				min.offer(num);
				max.offer(min.poll());
				flag = !flag;
			}
		}
		for (int i = 0; i < nums2.length; i++) {
			int num = nums2[i];
			if (flag) {// 第奇数个数，进小根堆（先进大根堆，再进小根堆）
				max.offer(num);
				min.offer(max.poll());
				flag = !flag;
			} else {// 第偶数个数，进大根堆（先进小根堆，再进大根堆）
				min.offer(num);
				max.offer(min.poll());
				flag = !flag;
			}
		}
		if (!flag) { // 总共偶数个数
			return (min.peek() + max.peek()) / 2.0;
		} else { // 总共奇数个数
			return min.peek();
		}

	}
}
