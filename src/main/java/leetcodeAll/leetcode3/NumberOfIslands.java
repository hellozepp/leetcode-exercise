package leetcodeAll.leetcode3;

/**
 * 200. Number of Islands
 */
public class NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int cnt = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++)
                if (grid[i][j] == '1') {
                    cnt++;
                    dfs(grid, i, j);
                }
        return cnt;
    }

    private void dfs(char[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0')
            return;
        grid[row][col] = '0';
        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

    //-----------------------------solution2--------------------------------
    int[][] distance = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public int numIslands2(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        UnionFind uf = new UnionFind(grid);
        int rows = grid.length, cols = grid[0].length;
        for (int i = 0; i < rows; i++)
            for (int j = 0; j < cols; j++)
                if (grid[i][j] == '1')
                    for (int[] d : distance) {
                        int x = i + d[0], y = j + d[1];
                        if (x >= 0 && x < rows && y >= 0 && y < cols && grid[x][y] == '1') {
                            int id1 = i * cols + j, id2 = x * cols + y;
                            uf.union(id1, id2);
                        }
                    }
        return uf.cnt;
    }

    class UnionFind {
        private int[] headMap;
        private int cnt;

        public UnionFind(char[][] grid) {
            int row = grid.length, col = grid[0].length;
            headMap = new int[row * col];
            cnt = 0;
            for (int i = 0; i < row; i++)
                for (int j = 0; j < col; j++)
                    if (grid[i][j] == '1') {
                        int tmp = i * col + j;
                        headMap[tmp] = tmp;
                        cnt++;
                    }
        }

        private int find(int id) {
            int head = headMap[id];
            if (head != id)
                head = find(head);
            headMap[id] = head;
            return head;
        }

        private void union(int id1, int id2) {
            int head1 = find(id1), head2 = find(id2);
            if (head1 != head2) {
                headMap[head1] = head2;
                cnt--;
            }
        }
    }
}
