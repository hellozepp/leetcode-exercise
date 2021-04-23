package leetcodeAll.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. Permutations
 * 
 * @author Watcher
 *
 */
public class Permutations {

	public static void main(String[] args) {
		Permutations so = new Permutations();
		int[] nums = { 1, 2, 3 };
		System.out.println(so.permute(nums));
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return res;
		backtrack(nums, res, new ArrayList<Integer>());
		return res;
	}

	private void backtrack(int[] nums, List<List<Integer>> res, List<Integer> list) {
		if (list.size() == nums.length)
			res.add(new ArrayList<>(list));
		else {
			for (int i = 0; i < nums.length; i++) {
				if (!list.contains(nums[i])) {
					list.add(nums[i]);
					backtrack(nums, res, list);
					list.remove(list.size() - 1);
				}
			}
		}
	}
}
