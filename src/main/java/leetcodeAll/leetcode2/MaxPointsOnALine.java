package leetcodeAll.leetcode2;

import others.Point;

import java.util.HashMap;
import java.util.Map;

/**
 * 149. Max Points on a Line
 */
public class MaxPointsOnALine {
    public int maxPoints(Point[] points) {
        if (points == null || points.length <= 2)
            return points.length;
        int res = 2;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < points.length - 1; i++) {
            map.clear();
            int overlap = 0, max = 1;
            for (int j = i + 1; j < points.length; j++) {
                int y = points[i].y - points[j].y, x = points[i].x - points[j].x;
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = gcd(y, x); //求最大公约数
                if (gcd != 1) {
                    x /= gcd;
                    y /= gcd;
                }
                if (map.containsKey(x)) {
                    if (map.get(x).containsKey(y)) {
                        map.get(x).put(y, map.get(x).get(y) + 1);
                    } else
                        map.get(x).put(y, 2);
                } else {
                    Map<Integer, Integer> mapy = new HashMap<>();
                    mapy.put(y, 2);
                    map.put(x, mapy);
                }
                max = Math.max(max, map.get(x).get(y));
            }
            res = Math.max(res, max + overlap);
        }
        return res;
    }

    private int gcd(int y, int x) {
        if (x == 0)
            return y;
        return gcd(x, y % x);
    }
}
