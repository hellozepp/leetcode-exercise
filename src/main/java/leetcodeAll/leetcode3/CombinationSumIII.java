package leetcodeAll.leetcode3;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> list = new ArrayList<>();
        help(list, k, n, 1);
        return res;
    }

    private void help(List<Integer> list, int k, int n, int cur) {
        if (k == 0 && n == 0)
            res.add(new ArrayList<>(list));
        if (k > 0 && n >= cur) {
            for (int i = cur; i < 10; i++) {
                list.add(i);
                help(list, k - 1, n - i, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
}
