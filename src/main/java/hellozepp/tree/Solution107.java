package hellozepp.tree;

import hellozepp.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 *  同 no.102
 *  不同在于要求 反着遍历
 * 给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回其自底向上的层序遍历为：
 *
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/binary-tree-level-order-traversal-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *  难度1.5星
 *
 */
public class Solution107 {


    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        track(root, list, 0);
        Collections.reverse(list);
        return list;
    }

    private void track(TreeNode root, List<List<Integer>> list, int h) {

        if (root == null) return;

        if (h >= list.size()) {
            list.add(h, new ArrayList<>());
        }


        list.get(h).add(root.val);

        track(root.left, list, h + 1);
        track(root.right, list, h + 1);

    }
}