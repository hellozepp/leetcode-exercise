package suanfa.leetcode;

import com.alibaba.dubbo.common.utils.Stack;
import javafx.util.Pair;
import suanfa.playWithAlgorithmsData.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class a230 {
    private static int solution(TreeNode node, int i) {
        if (node != null) {
            List<Integer>list = new ArrayList<Integer>();
            Stack<Pair<TreeNode, Boolean>> stack = new Stack<Pair<TreeNode, Boolean>>();
            stack.push(new Pair<TreeNode, Boolean>(node, false));
            while (!stack.isEmpty()) {
                Pair<TreeNode, Boolean> pop = stack.pop();
                if (pop.getValue() == true) {
                    list.add(pop.getKey().val);
                    if (list.size()==i)return list.get(i-1);
                } else {
                    if (pop.getKey().right != null) {
                        stack.push(new Pair(pop.getKey().right,false));
                    }
                    stack.push(new Pair(pop.getKey(),true));
                    if (pop.getKey().left != null) {
                        stack.push(new Pair(pop.getKey().left,false));
                    }
                }
            }
        }


        return -1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(6);
        treeNode.left = new TreeNode(3);
        TreeNode node = new TreeNode(8);
        node.left = new TreeNode(7);
//        node.right = new TreeNode(1);
        treeNode.right = node;
        int a = solution(treeNode, 3);
        System.out.println(a);
    }

}
