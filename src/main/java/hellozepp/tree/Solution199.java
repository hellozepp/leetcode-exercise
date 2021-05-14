package hellozepp.tree;

import hellozepp.TreeNode;

import java.util.ArrayList;
import java.util.List;


/**
 *
 * 求二叉树的
 *
 * 每层的 最后一个节点的集合
 *
 * 难度2星
 *
 */
public class Solution199 {

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        findRightView(root, result, 0);
        return result;
    }

    private void findRightView(TreeNode root, List<Integer> result, int depth) {
        if (root == null) {
            return;
        }
        if (depth == result.size()) {
            result.add(root.val);
        }

        findRightView(root.right, result, depth + 1);
        findRightView(root.left, result, depth + 1);
    }
}