package suanfa.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * {1, 2, 3}
 *全排列
 * [1, 2, 3]
 * [1, 3, 2]
 * [2, 1, 3]
 * [2, 3, 1]
 * [3, 1, 2]
 * [3, 2, 1]
 */
public class a46 {


    List<List<Integer>> res;
    boolean[] isUsed;

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = (new a46()).permute(nums);
        for (List<Integer> list : res)
            System.out.println(list);
    }

    private List<List<Integer>> solution(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        isUsed = new boolean[nums.length];
        LinkedList<Integer> p = new LinkedList<>();
        permutation(nums, 0, p);
        return res;

    }

    private void permutation(int[] nums, int k, LinkedList<Integer> p) {//全排列
        if (k == nums.length) {
            res.add((List<Integer>) p.clone());
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!isUsed[i]) {
                isUsed[i] = true;
                p.add(nums[i]);
                permutation(nums, k + 1, p);
                isUsed[i] = false;
                p.removeLast();
            }
        }
    }

    //标准写法 DFS
    public static List<List<Integer>> permute(int[] num) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(res, list, num);
        return res;
    }

    private static void helper(List<List<Integer>> res, List<Integer> list, int[] num) {
        if (list.size() == num.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (list.contains(num[i])) {
                continue;
            }
            list.add(num[i]);
            helper(res, list, num);
            list.remove(list.size() - 1);
        }
    }
}
