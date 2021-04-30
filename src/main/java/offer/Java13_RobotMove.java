/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题13：机器人的运动范围
 * // 题目：地上有一个m行n列的方格。一个机器人从坐标(0, 0)的格子开始移动，它
 * // 每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和
 * // 大于k的格子。例如，当k为18时，机器人能够进入方格(35, 37)，因为3+5+3+7=18。
 * // 但它不能进入方格(35, 38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
package offer;
import java.util.Scanner;


public class Java13_RobotMove {
	/**
	 * 
	 * @param threshold 约束值
	 * @param rows 		方格行数
	 * @param cols 		方格列数
	 * @return 			最多可走的方格数
	 */
	public int movingCount(int threshold, int rows, int cols)
	{
	    boolean[] visited = new boolean[rows * cols];
	    for (int i = 0; i < visited.length; i++) 
	        visited[i] = false;
	    int count = movingCountCore(threshold, rows, cols, 0, 0, visited);
	    return count;
	}
	
	/**
	 * 递归回溯方法
	 * @param threshold 约束值
	 * @param rows		方格行数
	 * @param cols		方格列数
	 * @param row		当前处理的行号
	 * @param col		当前处理的列号
	 * @param visited	访问标记数组
	 * @return			最多可走的方格数
	 */
	public int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
	    int count = 0;
	    if (check(threshold, rows, cols, row, col, visited)) {
	        visited[row * cols + col] = true;
	        count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited) +
	            movingCountCore(threshold, rows, cols, row, col - 1, visited) +
	            movingCountCore(threshold, rows, cols, row + 1, col, visited) +
	            movingCountCore(threshold, rows, cols, row, col + 1, visited);
	    }
	    return count;
	}
	
	public boolean check(int threshold, int rows, int cols, int row, int col, boolean[] visited) {
	    if (row >= 0 && row < rows && col >= 0 && col < cols && (getDigitSum(row) + getDigitSum(col) <= threshold)
	       && !visited[row * cols + col])
	        return true;
	    return false;
	}
	
	public int getDigitSum(int number) {
	    int sum = 0;
	    while (number > 0) {
	        sum += number % 10;
	        number /= 10;
	    }
	    return sum;
	}
	
	//测试用例
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入限制条件k:");
        int k = input.nextInt();
        System.out.println("请输入方格的行数m:");
        int m = input.nextInt();
        System.out.println("请输入方格的列数n:");
        int n = input.nextInt();
        
        Java13_RobotMove solution = new Java13_RobotMove();
        input.close();
        System.out.println("矩阵能达到的方格数是:");
        System.out.println(solution.movingCount(k, m, n));
    }
}
