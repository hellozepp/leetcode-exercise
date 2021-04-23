package leetcodeAll.leetcode2;

import others.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 113. Path Sum II
 */
public class PathSumII {
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> list = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null)
            return res;
        list.add(root.val);
        if (root.left == null && root.right == null && sum == root.val)
            res.add(new ArrayList<>(list));
        pathSum(root.left, sum - root.val);
        pathSum(root.right, sum - root.val);
        list.remove(list.size() - 1);
        return res;
    }
}
