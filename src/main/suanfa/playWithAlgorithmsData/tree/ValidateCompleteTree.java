package suanfa.playWithAlgorithmsData.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author: zhanglin
 * @Date: 2019/3/7
 * @Time: 2:40 PM
 */
public class ValidateCompleteTree {
//    validate complete binary tree.
//
//        1
//       /  \
//      3    5
//     / \   /
//    7  9  10
//    /
//    11

    public boolean validateCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean flag = false;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (flag) {
                    return false;
                }
                queue.offer(node.left);
            } else {
                flag = true;
            }

            if (node.right != null) {
                if (flag) {
                    return false;
                }
                queue.offer(node.right);
            } else {
                flag = true;
            }
        }
        return true;
    }

}
