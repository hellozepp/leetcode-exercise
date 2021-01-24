package suanfa.leetcode;

public class a208Tire {
    //实现字典树 find search startWith
    class TrieNode {
        public boolean isWord;
        public TrieNode child[];

        TrieNode() {
            isWord = false;
            child = new TrieNode[26];
        }
    }

    TrieNode root;

    public a208Tire() {
        root = new TrieNode();
    }

    public void insert(String word) {
        if (word == null) return;
        TrieNode r = root;
        for (int i = 0; i < word.length(); i++) {
            int id = word.charAt(i) - 'a';
            if (r.child[id] == null) {
                r.child[id] = new TrieNode();
            }
            r = r.child[id];
        }
        r.isWord = true;
    }

    public boolean search(String word) {
        if (word == null) return true;
        TrieNode r = root;
        for (int i = 0; i < word.length(); i++) {
            int id = word.charAt(i) - 'a';
            if (r.child[id] == null) {
                return false;
            }
            r = r.child[id];
        }
        return r.isWord;
    }

    public boolean startWith(String word) {
        if (word == null) return true;
        TrieNode r = root;
        for (int i = 0; i < word.length(); i++) {
            int id = word.charAt(i) - 'a';
            if (r.child[id] == null) {
                return false;
            }
            r = r.child[id];
        }
        return true;
    }
}
