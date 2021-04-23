package leetcodeAll.leetcode3;

/**
 * 208. Implement Trie (Prefix Tree)
 */
public class ImplementTrie {

    /**
     * 数据结构：每一层有26个结点的树形结构
     */
    class Node {
        public Node[] nexts = new Node[26];       //长度为26的Node类数组，表示当前字符对应结点的下一层
        boolean end;      //表示是否有字符串以当前结点对应的字符为结尾

        public void insert(Node cur, String word) {
            for (int i = 0; i < word.length(); i++) {   //逐级添加结点
                int index = word.charAt(i) - 'a';   // 当前字符在当前层的位置 0-25
                if (cur.nexts[index] == null)       //若当前位置为null，说明第一次出现，则新建结点
                    cur.nexts[index] = new Node();
                cur = cur.nexts[index];
            }
            cur.end = true;     //来到最后一层结点，设置当前结点的end为true，表示有一个字符串在这里结束
        }

        public boolean search(Node cur, String word) {  //根据添加顺序查找，一旦某一个位置为空则不存在这个字符串
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (cur.nexts[index] == null)
                    return false;
                cur = cur.nexts[index];
            }
            return cur.end;     //最后返回当前结点的end，判断是否为结束字符
        }

        public boolean startsWith(Node cur, String prefix) {        //和search逻辑类似，不需要判断结束字符的end
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (cur.nexts[index] == null)
                    return false;
                cur = cur.nexts[index];
            }
            return true;
        }
    }

    class Trie {
        Node head;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            head = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            head.insert(head, word);
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            return head.search(head, word);
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            return head.startsWith(head, prefix);
        }
    }
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */

}
