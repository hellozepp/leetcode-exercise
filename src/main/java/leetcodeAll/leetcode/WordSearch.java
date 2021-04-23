package leetcodeAll.leetcode;

/**
 * 79. Word Search
 * 
 * @author Watcher
 *
 */
public class WordSearch {

	public static void main(String[] args) {
		WordSearch so = new WordSearch();
		char[][] board = { { 'a', 'b' }, { 'c', 'd' } };
		System.out.println(so.exist(board, "abcd"));
	}

	public boolean exist(char[][] board, String word) {
		if (board == null || board.length * board[0].length < word.length())
			return false;
		boolean[][] used = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0) && backtrack(board, word.toCharArray(), used, i, j, 0))
					return true;
			}
		}
		return false;
	}

	private boolean backtrack(char[][] board, char[] word, boolean[][] used, int i, int j, int index) {
		if (i < 0 || i == board.length || j < 0 || j == board[0].length || used[i][j])
			return false;
		if (board[i][j] == word[index]) {
			if (index == word.length - 1)
				return true;
			used[i][j] = true;
			if (backtrack(board, word, used, i, j + 1, index + 1) || backtrack(board, word, used, i + 1, j, index + 1)
					|| backtrack(board, word, used, i, j - 1, index + 1) || backtrack(board, word, used, i - 1, j, index + 1))
				return true;
			else
				used[i][j] = false;
		}
		return false;
	}
}
