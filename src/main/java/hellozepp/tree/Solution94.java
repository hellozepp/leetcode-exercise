package hellozepp.tree;

import hellozepp.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
     * 中序遍历  不使用递归
     * <p>
     * 难度 2星
     */
    public  class Solution94 {


        public List<Integer> inorderTraversal(TreeNode root) {
            List list = new ArrayList<>();

            Stack<TreeNode> stack = new Stack();

            TreeNode node =root;
            while (node!=null||!stack.isEmpty()) {

                while (node!=null){
                    stack.push(node);
                    node= node.left;
                }
                node =stack.pop();
                list.add(node.val);
                node = node.right;
            }

            return list;
        }

        /**
         * 递归方式很简单
         *
         * @param root
         */
        public List<Integer> inorderTraversal2(TreeNode root) {

            List list = new ArrayList<>();
            traversal(list, root);
            return list;
        }


        private void traversal(List list, TreeNode root) {

            if (root == null) return;
            traversal(list, root.left);
            list.add(root.val);
            traversal(list, root.right);
        }
    }