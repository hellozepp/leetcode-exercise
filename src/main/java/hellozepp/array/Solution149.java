package hellozepp.array;

import others.Point;

import java.util.HashMap;

/**
 * @Author: zhanglin
 * @Date: 2021/5/6
 * @Time: 4:52 PM
 *
 * 149. 直线上最多的点数
 * 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 *
 * 示例 1:
 *
 * 输入: [[1,1],[2,2],[3,3]]
 * 输出: 3
 * 解释:
 * ^
 * |
 * |        o
 * |     o
 * |  o
 * +------------->
 * 0  1  2  3  4
 * 示例 2:
 *
 * 输入: [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
 * 输出: 4
 * 解释:
 * ^
 * |
 * |  o
 * |     o        o
 * |        o
 * |  o        o
 * +------------------->
 * 0  1  2  3  4  5  6
 *
 * 难度: 困难
 */
public class Solution149 {
    /**
     * 暴力解
     * @param points
     * @return
     */
    public int maxPoints1(Point[] points) {
        // 如果总坐标点少于 3 个，直接返回答案
        int n = points.length;
        if (points.length <= 2) {
            return n;
        }
        // 搜索直线上最多的点数
        int max = 0;
        for (int i = 0; i < n; i++) {
            // same 表示有多少个和 i 一样的点
            int same = 1;
            for (int j = i + 1; j < n; j++) {
                // cnt 表示除了 i 坐标点外，有多少个点在 i、j 坐标点构成的直线上
                int cnt = 0;
                if (points[i].x == points[j].x && points[i].y == points[j].y) {
                    // i、j 是重复点，计数
                    same++;
                } else {
                    // i、j 不是重复点，检查其他点是否在这条直线上，j 坐标点也在这条直线上，所以 cnt ++
                    cnt++;
                    long xRange = (long) (points[i].x - points[j].x);
                    long yRange = (long) (points[i].y - points[j].y);
                    for (int k = j + 1; k < n; k++) {
                        if (xRange * (points[i].y - points[k].y) == yRange * (points[i].x - points[k].x)) {
                            cnt++;
                        }
                    }
                }
                // 最大值比较
                max = Math.max(max, cnt + same);
            }
        }
        return max;
    }

    public int maxPoints(Point[] points) {
        int n = points.length;
        if (0 == n) {
            return 0;
        }
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            count[i] = 1;
            int size = 1;
            int same = 0;
            HashMap<Integer[], Integer> hashMap = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    if (points[i].x != points[j].x) {
                        int dy = points[i].y - points[j].y;
                        int dx = points[i].x - points[j].x;
                        int gcd = gcd(dy, dx);
                        if (0 != gcd) {
                            dy = dy / gcd;
                            dx = dx / gcd;
                        }
                        Integer[] nums = new Integer[2];
                        nums[0] = dy;
                        nums[1] = dx;
                        boolean flag = false;
                        for (Integer[] array : hashMap.keySet()) {
                            if (nums[0].equals(array[0]) && nums[1].equals(array[1])) {
                                flag = true;
                                hashMap.put(array, hashMap.get(array) + 1);
                            }
                        }
                        if (!flag) {
                            hashMap.put(nums, 1);
                        }
                    } else {
                        if (points[i].y == points[j].y) {
                            same++;
                        }
                        size++;
                    }
                }
            }
            for (Integer[] array : hashMap.keySet()) {
                if (hashMap.get(array) + 1 > count[i]) {
                    count[i] = hashMap.get(array) + 1;
                }
            }
            count[i] += same;
            count[i] = Math.max(count[i], size);
        }
        int maxIndex = 0;
        for (int i = 1; i < n; i++) {
            if (count[i] > count[maxIndex]) {
                maxIndex = i;
            }
        }
        return count[maxIndex];
    }

    private int gcd(int x, int y) {
        if (y == 0) {
            return x;
        }
        return gcd(y, x % y);
    }

    public static void main(String[] args) {
        System.out.println(new Solution149().maxPoints(new Point[]
                {new Point(1, 1), new Point(3, 2), new Point(5, 3),
                        new Point(4, 1), new Point(2, 3), new Point(1, 4)}));
        System.out.println(new Solution149().maxPoints(new Point[]
                {new Point(1, 1), new Point(3, 2), new Point(5, 3),
                        new Point(4, 1)}));
    }
}
