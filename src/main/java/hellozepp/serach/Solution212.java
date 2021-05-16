package hellozepp.serach;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author: zhanglin
 * @Date: 2021/5/16
 * @Time: 9:16 PM
 * 单词搜索II
 * 难度 hard
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words，找出所有同时在二维网格和字典中出现的单词。
 *
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 * 示例 1：
 *
 *
 * 输入：board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
 * words = ["oath","pea","eat","rain"]
 * 输出：["eat","oath"]
 * 示例 2：
 *
 *
 * 输入：board = [["a","b"],["c","d"]], words = ["abcb"]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * m == board.length
 * n == board[i].length
 * 1 <= m, n <= 12
 * board[i][j] 是一个小写英文字母
 * 1 <= words.length <= 3 * 104
 * 1 <= words[i].length <= 10
 * words[i] 由小写英文字母组成
 * words 中的所有字符串互不相同
 */
public class Solution212 {
    public List<String> findWords(char[][] board, String[] words) {
        WordTrie trie = new WordTrie();
        for (String word : words) {
            trie.insert(word);
        }
        boolean[][] visited = new boolean[board.length][board[0].length];
        Set<String> res = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                find(board, i, j, res, visited, trie.root);
            }
        }
        return new ArrayList<>(res);
    }

    private void find(char[][] board, int i, int j, Set<String> res, boolean[][] visited, TreeNode node) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || visited[i][j]) {
            return;
        }
        node = node.child[board[i][j] - 'a'];
        if (node == null) {
            return;
        }
        if (node.isEnd) {
            res.add(node.value);
        }
        visited[i][j] = true;
        find(board, i - 1, j, res, visited, node);
        find(board, i + 1, j, res, visited, node);
        find(board, i, j - 1, res, visited, node);
        find(board, i, j + 1, res, visited, node);
        visited[i][j] = false;
    }

    public class WordTrie {
        TreeNode root;

        WordTrie() {
            root = new TreeNode();
        }

        public void insert(String word) {
            TreeNode cur = root;
            for (int i = 0; i < word.length(); i++) {
                if (cur.child[word.charAt(i) - 'a'] == null) {
                    cur.child[word.charAt(i) - 'a'] = new TreeNode();
                }
                cur = cur.child[word.charAt(i) - 'a'];
            }
            cur.isEnd = true;
            cur.value = word;
        }
    }

    public class TreeNode {
        String value;
        TreeNode[] child;
        boolean isEnd;

        public TreeNode() {
            this.child = new TreeNode[26];
            this.isEnd = false;
        }
    }
}
