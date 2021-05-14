package hellozepp.tree;

import hellozepp.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 * 同No.102
 *
 * 不同点在于 顺序会 来回反转
 *  给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。
 *
 * 例如：
 * 给定二叉树 [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 返回锯齿形层序遍历如下：
 *
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 *
 * 解法：偶数层往前面插入，整层则为逆序
 * 难度2星
 *
 */
public class Solution103 {


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> list = new ArrayList<>();
        track(root, list, 0);
        return list;
    }

    private void track(TreeNode root, List<List<Integer>> list, int h) {

        if (root == null) {
            return;
        }

        if (h >= list.size()) {
            list.add(h, new ArrayList<>());
        }

        if (h % 2 == 0) {
            list.get(h).add(root.val);
        } else {
            list.get(h).add(0, root.val);
        }

        track(root.left, list, h + 1);
        track(root.right, list, h + 1);


    }
}