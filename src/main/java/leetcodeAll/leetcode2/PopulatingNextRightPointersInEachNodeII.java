package leetcodeAll.leetcode2;

import others.TreeLinkNode;

/**
 * 117. Populating Next Right Pointers in Each Node II
 */
public class PopulatingNextRightPointersInEachNodeII {

    public void connect(TreeLinkNode root) {
        while (root != null) {
            TreeLinkNode pre = new TreeLinkNode(-1);
            TreeLinkNode cur = pre;
            while (root != null) {
                if (root.left != null) {
                    cur.next = root.left;
                    cur = cur.next;
                }
                if (root.right != null) {
                    cur.next = root.right;
                    cur = cur.next;
                }
                root = root.next;
            }
            root = pre.next;
        }
    }

    public void connect2(TreeLinkNode root) {
        TreeLinkNode level = root;
        while (level != null) {
            TreeLinkNode cur = level;
            while (cur != null) {
                if (cur.left != null || cur.right != null) {
                    if (cur.left != null && cur.right != null)
                        cur.left.next = cur.right;
                    TreeLinkNode tmp = cur.right != null ? cur.right : cur.left;
                    TreeLinkNode next = cur.next;
                    while (next != null && next.left == null && next.right == null)
                        next = next.next;
                    if (next != null && (next.left != null || next.right != null))
                        tmp.next = next.left != null ? next.left : next.right;
                }
                cur = cur.next;
            }
            while (level != null && level.left == null && level.right == null)
                level = level.next;
            if (level != null && (level.left != null || level.right != null))
                level = level.left != null ? level.left : level.right;
        }
    }
}
