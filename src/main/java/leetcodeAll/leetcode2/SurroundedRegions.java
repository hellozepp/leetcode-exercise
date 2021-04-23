package leetcodeAll.leetcode2;

/**
 * 130. Surrounded Regions
 */
public class SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length <= 2 || board[0].length <= 2)
            return;
        int ROW = board.length, COL = board[0].length;
        //遍历边界，将毗连的O变成Y
        for (int i = 0; i < ROW; i++) {
            if (board[i][0] == 'O')
                change(board, i, 0, 'Y');
            if (board[i][COL - 1] == 'O')
                change(board, i, COL - 1, 'Y');
        }
        for (int i = 0; i < COL; i++) {
            if (board[0][i] == 'O')
                change(board, 0, i, 'Y');
            if (board[ROW - 1][i] == 'O')
                change(board, ROW - 1, i, 'Y');
        }
        //遍历board，将O变成X，将Y变成O
        for (int i = 0; i < ROW; i++)
            for (int j = 0; j < COL; j++)
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == 'Y')
                    board[i][j] = 'O';
    }

    private void change(char[][] board, int row, int col, char ch) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != 'O')
            return;
        board[row][col] = ch;
        change(board, row - 1, col, ch);
        change(board, row + 1, col, ch);
        change(board, row, col - 1, ch);
        change(board, row, col + 1, ch);
    }
}
