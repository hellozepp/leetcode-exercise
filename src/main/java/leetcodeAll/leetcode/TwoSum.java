package leetcodeAll.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;

/**
 * 1. Two Sum
 * 
 * Given an array of integers, return indices of the two numbers such that they add up to a specific
 * target. You may assume that each input would have exactly one solution, and you may not use the
 * same element twice.
 * 
 * @author Watcher
 *
 */
public class TwoSum {

	/**
	 * 单个哈希表实现
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum(int[] nums, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			int a = nums[i];
			int b = target - a;
			if (map.containsKey(b)) // 如果map里存放了b
				return new int[] { map.get(b), i };
			map.put(a, i);
		}
		return null;
	}

	/**
	 * 自己用哈希表实现，对value重拍，后来发现，纯属多此一举
	 * 
	 * @param nums
	 * @param target
	 * @return
	 */
	public int[] twoSum2(int[] nums, int target) {
		if (nums == null || nums.length < 2)
			return null;
		int[] res = new int[2];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++)
			map.put(i, nums[i]);
		int start = 0, end = nums.length - 1;
		ArrayList<Entry<Integer, Integer>> list = new ArrayList<Entry<Integer, Integer>>(map.entrySet());
		Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return o1.getValue() - o2.getValue();
			}
		});

		while (start < end) {
			if (list.get(start).getValue() + list.get(end).getValue() == target) {
				res[0] = list.get(start).getKey();
				res[1] = list.get(end).getKey();
				return res;
			} else if (list.get(start).getValue() + list.get(end).getValue() > target) {
				end--;
			} else {
				start++;
			}
		}

		return res;
	}
}
