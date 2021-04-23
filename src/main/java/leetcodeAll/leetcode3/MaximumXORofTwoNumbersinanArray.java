package leetcodeAll.leetcode3;

/**
 * 421. Maximum XOR of Two Numbers in an Array
 */
public class MaximumXORofTwoNumbersinanArray {
    public int findMaximumXOR(int[] nums) {
        NumTrie trie = new NumTrie();
        trie.add(nums[0]);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max(max, trie.maxEor(nums[i]));
            trie.add(nums[i]);
        }
        return max;
    }

    public static class Node {
        public Node[] nexts = new Node[2];
    }

    public static class NumTrie {
        Node head = new Node();

        public void add(int num) {
            Node cur = head;
            for (int move = 31; move >= 0; move--) {
                int path = (num >> move) & 1;
                cur.nexts[path] = cur.nexts[path] == null ? new Node() : cur.nexts[path];
                cur = cur.nexts[path];
            }
        }

        public int maxEor(int num) {
            Node cur = head;
            int res = 0;
            for (int move = 31; move >= 0; move--) {
                int path = (num >> move) & 1;
                int best = move == 31 ? path : (path ^ 1);
                best = cur.nexts[best] == null ? best ^ 1 : best;
                res |= (path ^ best) << move;
                cur = cur.nexts[best];
            }
            return res;
        }
    }
}
