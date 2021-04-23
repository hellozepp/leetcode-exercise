package suanfa.interview;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 有n个矩形，每个矩形可以用两个整数a,b表示，分别表示它的长和宽。矩形X(a,b)可以嵌套在矩形Y(c,d)中当且仅当a<c,b<d或b<c,a<d。
 *
 * 例如：1,5可以嵌套在6,2内，但不能嵌套在3,4内。
 *
 * 给出n个矩形，选出尽量多的矩形排成一行，使得除了最后一个之外，每一个矩形都可以嵌套在下一个矩形内。
 *
 * 先输入矩形的数目n，紧接着输入n行，每行代表一个矩形，最后输出选出的矩形。
 *
 * 样例输入：
 *
 * 6
 * 1,2
 * 4,3
 * 4,6
 * 3,17
 * 7,8
 * 10,11
 *
 * 样例输出：
 *
 * 1,2
 * 4,3
 * 4,6
 * 7,8
 * 10,11
 *
 * 思路：如果矩形X包含在矩形Y中，我们就从矩形X到Y连一条有向边；N个结点构成一个有向无环图DAG，我们的任务就是求DAG上的最长路径。
 *
 * 设d(i)表示从结点i出发的最长路径长度，则d(i)=max[d(j)+1|(i,j)∈E]，其中E为边集。最终答案为所有d(i)中的最大值。
 *
 * 根据状态转移方程，可以尝试递推或记忆化搜索求解。对于状态递推顺序不容易确定时，记忆化搜索更方便一些。当终点固定时，递推更方便一些。
 */
public class 矩形嵌套 {
    public static int dpSolution(int[][] edg, int[] d, int index) {
        if (d[index] >= 0)
            return d[index];
        d[index] = 1;
        for (int i = 0; i < edg.length; i++) {
            if (edg[index][i] == 1) {
                int temp = dpSolution(edg, d, i) + 1;
                if (temp > d[index])
                    d[index] = temp;
            }
        }
        return d[index];
    }

    public static void print(int[][] a, int[][] edg, int[] d, int index) {
        System.out.println(a[index][0] + "," + a[index][1]);
        for (int i = 0; i < d.length; i++) {
            if (edg[index][i] == 1 && d[index] - d[i] == 1) {
                print(a, edg, d, i);
                break;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            scanner.nextLine();
            int[][] a = new int[n][2];
            int[][] edg = new int[n][n];
            int[] d = new int[n];
            Arrays.fill(d, -1);
            for (int i = 0; i < n; i++) {
                String s = scanner.nextLine();
                String[] temp = s.split(",");
                a[i][0] = Integer.parseInt(temp[0]);
                a[i][1] = Integer.parseInt(temp[1]);
            }
            for (int i = 0; i < n; i++) {        //用邻接矩阵存储各个矩形的包含关系
                for (int j = i + 1; j < n; j++) {
                    if ((a[i][0] < a[j][0] && a[i][1] < a[j][1]) || (a[i][1] < a[j][0] && a[i][0] < a[j][1])) {
                        edg[i][j] = 1;
                    } else if ((a[i][0] > a[j][0] && a[i][1] > a[j][1]) || (a[i][1] > a[j][0] && a[i][0] > a[j][1])) {
                        edg[j][i] = 1;
                    }
                }
            }
            for (int i = 0; i < n; i++) {
                dpSolution(edg, d, i);
            }
            int max = 0, num = 0;
            for (int i = 0; i < n; i++) {
                if (d[i] > max) {
                    max = d[i];
                    num = i;
                }
            }
            print(a, edg, d, num);
        }
        scanner.close();
    }
}