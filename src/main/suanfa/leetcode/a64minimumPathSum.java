package suanfa.leetcode;

public class a64minimumPathSum {
    /*
 * 从给定的网格中找到最短路径
 *
 * 方向只能 down或 right
 *
 * 难度2星
 *f(xy)= min(f(x-1,y),f(x,y-1))+f(x,y)
 * FIXME
 *
 */
    public int Solution64 (int[][] grid){
        int row = grid.length;
        int col = grid[0].length;
        for (int i=0;i<row;i++){
            for (int j=0;j<col;j++){
                if (i==0&&j==0){//pass
                }else if (i!=0&&j==0){
                    grid[i][j]=grid[i-1][j]+grid[i][j];
                }else if  (j!=0&&i==0){
                    grid[i][j]=grid[i][j-1]+grid[i][j];
                }else {
                    grid[i][j]=Math.min(grid[i-1][j],grid[i][j-1])+grid[i][j];
                }
            }
        }
        return grid[row-1][col-1];
    }
}
