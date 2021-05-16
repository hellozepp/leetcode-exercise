package hellozepp.dp;

import java.util.List;


/**
 * 三角形最小路径和
 * 给点数组 求从上到下的最短距离 每次下移的时候 可以移动到相邻的位置
 * 题目详情
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 * <p>
 * 难度2.5星
 * <p>
 * FIXME
 */
public class Solution120 {


    /**
     * 状态转移方程：
     * S[i][j] = min(S[i+1][j] , S[i+1][j+1]) +S[i][j]
     * S[0][0]就是要求解的答案。
     *
     *
     * @param triangle
     * @return
     */
    public int minimumTotal(List<List<Integer>> triangle) {

        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                triangle.get(i).set(j, triangle.get(i).get(j)
                        + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
            }
        }
        return triangle.get(0).get(0);
    }

    public static void main(String[] args) {

    }

}