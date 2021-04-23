package leetcodeAll.leetcode3;

/**
 * 211. Add and Search Word - Data structure design
 */
public class AddAndSearchWordDataStructureDesign {

    class Node {
        Node[] nexts = new Node[26];
        boolean end;
    }

    class WordDictionary {
        Node root;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            root = new Node();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            Node cur = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (cur.nexts[index] == null)
                    cur.nexts[index] = new Node();
                cur = cur.nexts[index];
            }
            cur.end = true;
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return search(0, word, root, false);
        }

        private boolean search(int index, String word, Node root, boolean res) {
            if (res || index == word.length())
                return root.end;
            if (word.charAt(index) == '.') {
                for (Node n : root.nexts) {
                    if (n != null)
                        res |= search(index + 1, word, n, res);
                }
            } else {
                if (root.nexts[word.charAt(index) - 'a'] == null)
                    return false;
                res |= search(index + 1, word, root.nexts[word.charAt(index) - 'a'], false);
            }
            return res;
        }
    }
/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
