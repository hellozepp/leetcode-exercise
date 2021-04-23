package leetcodeAll.leetcode2;

/**
 * 174. Dungeon Game
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        dungeon[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1)
                    continue;
                if (i == m - 1)
                    dungeon[i][j] = Math.max(1, dungeon[i][j + 1] - dungeon[i][j]);
                else if (j == n - 1)
                    dungeon[i][j] = Math.max(1, dungeon[i + 1][j] - dungeon[i][j]);
                else {
                    int dowm = Math.max(1, dungeon[i + 1][j] - dungeon[i][j]);
                    int right = Math.max(1, dungeon[i][j + 1] - dungeon[i][j]);
                    dungeon[i][j] = Math.min(dowm, right);
                }
            }
        return dungeon[0][0];
    }

    public int calculateMinimumHP2(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] mins = new int[m][n];  //骑士到达d[i][j]位置时需要的最少初始血量为mins[i][j]
        mins[m - 1][n - 1] = Math.max(1, 1 - dungeon[m - 1][n - 1]);
        for (int i = m - 1; i >= 0; i--)
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1)
                    continue;
                if (i == m - 1)
                    mins[i][j] = Math.max(1, mins[i][j + 1] - dungeon[i][j]);
                else if (j == n - 1)
                    mins[i][j] = Math.max(1, mins[i + 1][j] - dungeon[i][j]);
                else {
                    int dowm = Math.max(1, mins[i + 1][j] - dungeon[i][j]);
                    int right = Math.max(1, mins[i][j + 1] - dungeon[i][j]);
                    mins[i][j] = Math.min(dowm, right);
                }
            }
        return mins[0][0];
    }
}
