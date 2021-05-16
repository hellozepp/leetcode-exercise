package suanfa.leetcode;

import suanfa.playWithAlgorithmsData.tree.TreeNode;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 *
 * 叶子节点 是指没有子节点的节点。
 */
public class a113 {
    public static int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        return findPath(root, sum)
                + pathSum(root.left, sum)
                + pathSum(root.right, sum);
    }

    private static int findPath(TreeNode root, int sum) {
        if (root == null) return 0;
        int res = 0;
        if (root.val == sum) res += 1;
        res += findPath(root.left, sum - root.val);
        res += findPath(root.right, sum - root.val);
        return res;
    }

    public static void main(String[] args) {

        // 手动创建Leetcode题页上的测试用例。
        // 当然, 有更好的更智能的创建二叉树的方式, 有兴趣的同学可以自行研究编写程序:)

        /*****************
         * 测试用例:
         *
         *       10
         *      /  \
         *     5   -3
         *    / \    \
         *   3   2   11
         *  / \   \
         * 3  -2   1
         *****************/
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(-2);

        TreeNode node3 = new TreeNode(3);
        node3.left = node1;
        node3.right = node2;

        TreeNode node4 = new TreeNode(1);
        TreeNode node5 = new TreeNode(2);
        node5.right = node4;

        TreeNode node6 = new TreeNode(5);
        node6.left = node3;
        node6.right = node5;

        TreeNode node7 = new TreeNode(11);
        TreeNode node8 = new TreeNode(-3);
        node8.right = node7;

        TreeNode node9 = new TreeNode(10);
        node9.left = node6;
        node9.right = node8;

        System.out.println(pathSum(node9, 8));
    }
}
