package leetcodeAll.leetcode2;

import others.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 116. Populating Next Right Pointers in Each Node
 */
public class PopulatingNextRightPointersInEachNode {

    public void connect(TreeLinkNode root) {
        TreeLinkNode level = root;
        while (level != null) {
            TreeLinkNode cur = level;
            while (cur != null) {
                if (cur.left != null)
                    cur.left.next = cur.right;
                if (cur.right != null && cur.next != null)
                    cur.right.next = cur.next.left;
                cur = cur.next;
            }
            level = level.left;
        }
    }

    public void connect2(TreeLinkNode root) {
        if (root == null)
            return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                root = queue.poll();
                root.next = size == 0 ? null : queue.peek();
                if (root.left != null)
                    queue.offer(root.left);
                if (root.right != null)
                    queue.offer(root.right);
            }
        }
    }
}
