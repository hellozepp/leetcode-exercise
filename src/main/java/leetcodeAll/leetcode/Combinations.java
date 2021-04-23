package leetcodeAll.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 * 
 * @author Watcher
 *
 */
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> res = new ArrayList<>();
		if (n < k)
			return res;
		backtrack(res, new ArrayList<Integer>(), 1, n, k);
		return res;
	}

	private void backtrack(List<List<Integer>> res, List<Integer> list, int index, int n, int k) {
		if (list.size() == k)
			res.add(new ArrayList<>(list));
		else {
			for (int i = index; i <= n; i++) {
				if (n - i + 1 + list.size() < k)
					return;
				list.add(i);
				backtrack(res, list, i + 1, n, k);
				list.remove(list.size() - 1);
			}
		}
	}
}
