package leetcodeAll.leetcode3;

import java.util.ArrayList;
import java.util.List;

/**
 * 212. Word Search II
 */
public class WordSearchII {
    //----------------------solution1--------------599ms---
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            boolean[][] used = new boolean[board.length][board[0].length];
            boolean done = false;
            for (int i = 0; i < board.length && !done; i++)
                for (int j = 0; j < board[0].length && !done; j++)
                    if (board[i][j] == word.charAt(0))
                        done = backtrack(board, used, word, 0, i, j, false);
            if (done)
                res.add(word);
        }
        return res;
    }

    private boolean backtrack(char[][] board, boolean[][] used, String word, int index, int row, int col, boolean done) {
        if (done || index == word.length())
            return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || used[row][col] || board[row][col] != word.charAt(index))
            return false;
        used[row][col] = true;
        done = backtrack(board, used, word, index + 1, row - 1, col, false);
        done = done || backtrack(board, used, word, index + 1, row + 1, col, false);
        done = done || backtrack(board, used, word, index + 1, row, col - 1, false);
        done = done || backtrack(board, used, word, index + 1, row, col + 1, false);
        used[row][col] = false;
        return done;
    }

    //--------------------solution2--------309ms------
    public List<String> findWords2(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        for (String word : words) {
            boolean done = false;
            for (int i = 0; i < board.length && !done; i++)
                for (int j = 0; j < board[0].length && !done; j++)
                    if (board[i][j] == word.charAt(0))
                        done = backtrack2(board, word, 0, i, j, false);
            if (done)
                res.add(word);
        }
        return res;
    }

    private boolean backtrack2(char[][] board, String word, int index, int row, int col, boolean done) {
        if (done || index == word.length())
            return true;
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index))
            return false;
        board[row][col] ^= 256;
        done = backtrack2(board, word, index + 1, row - 1, col, false);
        done = done || backtrack2(board, word, index + 1, row + 1, col, false);
        done = done || backtrack2(board, word, index + 1, row, col - 1, false);
        done = done || backtrack2(board, word, index + 1, row, col + 1, false);
        board[row][col] ^= 256;
        return done;
    }

    //-----------solution3---------10ms-------
    public List<String> findWords3(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        Trie trie = new Trie();
        for (String word : words)
            trie.addWord(word);
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                search(res, board, trie.root, i, j);
        return res;
    }

    private void search(List<String> res, char[][] board, TrieNode cur, int row, int col) {
        if (row < 0 || row == board.length || col < 0 || col == board[0].length || board[row][col] == '#' || cur.nexts[board[row][col] - 'a'] == null)
            return;
        char c = board[row][col];
        cur = cur.nexts[c - 'a'];
        if (cur.word != null) {
            res.add(cur.word);
            cur.word = null;
        }
        board[row][col] = '#';
        search(res, board, cur, row - 1, col);
        search(res, board, cur, row + 1, col);
        search(res, board, cur, row, col - 1);
        search(res, board, cur, row, col + 1);
        board[row][col] = c;
    }

    class TrieNode {
        TrieNode[] nexts = new TrieNode[26];
        String word;
    }

    class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (cur.nexts[index] == null)
                    cur.nexts[index] = new TrieNode();
                cur = cur.nexts[index];
            }
            cur.word = word;
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'b', 'a', 'a', 'b', 'a', 'b'}, {'a', 'b', 'a', 'a', 'a', 'a'}, {'a', 'b', 'a', 'a', 'a', 'b'}, {'a', 'b', 'a', 'b', 'b', 'a'}, {'a', 'a', 'b', 'b', 'a', 'b'}, {'a', 'a', 'b', 'b', 'b', 'a'}, {'a', 'a', 'b', 'a', 'a', 'b'}};
        String[] words = {"aabbbbabbaababaaaabababbaaba", "abaabbbaaaaababbbaaaaabbbaab", "ababaababaaabbabbaabbaabbaba"};
        WordSearchII so = new WordSearchII();
        System.out.println(so.findWords(board, words));
    }
}
