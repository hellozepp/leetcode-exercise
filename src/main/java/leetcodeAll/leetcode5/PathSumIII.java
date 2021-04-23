package leetcodeAll.leetcode5;

import others.TreeNode;

/**
 * 437. Path Sum III
 */
public class PathSumIII {

    /**
     * 耗时10ms
     * @param root
     * @param sum
     * @return
     */
    public int pathSum(TreeNode root, int sum) {
        if (root == null)
            return 0;
        int[] sums = new int[1001];
        return path(root, sums, 0, sum);
    }

    private int path(TreeNode root, int[] sums, int index, int sum) {
        if (root == null)
            return 0;
        int cnt = 0;
        sums[index] = root.val;
        if (index > 0)
            sums[index] += sums[index - 1];
        cnt += sums[index] == sum ? 1 : 0;
        for (int i = 0; i < index; i++)
            if (sums[index] - sums[i] == sum)
                cnt++;
        cnt += path(root.left, sums, index + 1, sum);
        cnt += path(root.right, sums, index + 1, sum);
        return cnt;
    }

    /**
     * 耗时17ms
     *
     * @param root
     * @param sum
     * @return
     */
    public int pathSum2(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return path2(root, sum) + pathSum2(root.left, sum) + pathSum2(root.right, sum);
    }

    private int path2(TreeNode root, int sum) {
        if (root == null)
            return 0;
        return (sum == root.val ? 1 : 0) + path2(root.left, sum - root.val) + path2(root.right, sum - root.val);
    }
}
