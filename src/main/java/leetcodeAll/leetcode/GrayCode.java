package leetcodeAll.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. Gray Code
 * 
 * @author Watcher
 *
 */
public class GrayCode {

	public List<Integer> grayCode(int n) {
		List<Integer> res = new ArrayList<>();
		n = 1 << n;
		for (int i = 0; i < n; i++)
			res.add(i ^ (i >> 1));
		return res;
	}

	public List<Integer> grayCode2(int n) {
		List<Integer> res = new ArrayList<>();
		// int cnt = 1;
		res.add(0);
		while (n-- > 0) {
			int cnt = res.size();
			for (int i = cnt - 1; i >= 0; i--)
				res.add(res.get(i) + cnt);
		}
		return res;
	}
}
