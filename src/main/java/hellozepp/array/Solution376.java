package hellozepp.array;

/**
 * @Author: zhanglin
 * @Date: 2021/5/15
 * @Time: 5:53 PM
 * 摇摆序列，整数序列中两个相邻元素差为正负交替出现，1个元素直接为摇摆序列
 *
 * 题目：
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除
 * 一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 *
 * 由于给定的数列中的数据是可以丢掉来求最大子序列的所以在求得时候，和以前求最大子序列得方式不一样，
 * 总的来说，使用的是贪心算法，且配合一个switch的状态机的方式来计算结果。
 * 示例 1:
 *
 * 输入: [1,7,4,9,2,5]
 * 输出: 6
 * 解释: 整个序列均为摆动序列。
 * 示例 2:
 *
 * 输入: [1,17,5,10,13,15,10,5,16,8]
 * 输出: 7
 * 解释: 这个序列包含几个长度为 7 摆动序列，其中一个可为[1,17,10,13,10,16,8]。
 * 示例 3:
 *
 * 输入: [1,2,3,4,5,6,7,8,9]
 * 输出: 2
 */
public class Solution376 {
    public int wiggleMaxLength(int[] arr) {
        if (arr.length < 2) {
            return arr.length;
        }
        final int start = 0, up = 1, down = 2;
        int status = start;
        int res = 1;
        for (int i = 1; i < arr.length; i++) {
            switch (status) {
                case start: {
                    if (arr[i] < arr[i - 1]) {
                        status = down;
                        res++;
                    } else if (arr[i] > arr[i - 1]) {
                        status = up;
                        res++;
                    }
                    break;
                }
                case up: {
                    if (arr[i] < arr[i - 1]) {
                        status = down;
                        res++;
                    }
                    break;
                }
                case down: {
                    if (arr[i] > arr[i - 1]) {
                        status = up;
                        res++;
                    }
                    break;
                }
            }
        }
        return res;
    }
}
