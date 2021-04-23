package leetcodeAll.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum
 * 
 * @author Watcher
 *
 */
public class CombinationSum {

	public static void main(String[] args) {
		CombinationSum so = new CombinationSum();
		int[] candidates = { 1, 2, 3 };
		System.out.println(so.combinationSum(candidates, 4));
	}

	List<List<Integer>> res = new ArrayList<List<Integer>>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		if (candidates.length == 0 || target < candidates[0])
			return res;
		combination(candidates, target, 0, new ArrayList<Integer>());
		return res;
	}

	private void combination(int[] candidates, int target, int index, List<Integer> list) {
		if (target == 0) {
			res.add(new ArrayList<Integer>(list));
			return;
		}
		for (int i = index; i < candidates.length; i++) {
			if (target < candidates[i])
				return;
			list.add(candidates[i]);
			combination(candidates, target - candidates[i], i, list);
			list.remove(list.size() - 1);
		}
	}

}
