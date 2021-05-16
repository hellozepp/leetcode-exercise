package suanfa.playWithAlgorithmsData.动态规划;

import java.util.HashMap;

public class Fib {
    //    、、数列：1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, …
    public static void main(String[] args) {
        int _ = 1000;
        int fib = fib2_1(_);
        int fib1 = fib2(_);
        System.out.println(fib);
        System.out.println(fib1);
    }

    private static int fib(int i) {
        if (i == 1 || i == 2) {
            return i;
        }
        return fib(i - 1) + fib(i - 2);
    }

    //    记忆化搜索
    private static HashMap<Integer, Integer> map = new HashMap<>();

    private static int fib2_1(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1 || i == 2) {
            return i;
        }
        if (map.containsKey(i)) {
            return map.get(i);
        }
        map.put(i, fib2_1(i - 1) + fib2_1(i - 2));
        return map.get(i);
    }

    //动态规划
    // 1.求解连续子问题
    // 2.将计算过的结果保存起来，只需要计算一次
    private static int fib2(int n) {
        HashMap<Integer, Integer> map = new HashMap<>(n);
        map.put(0, 1);
        map.put(1, 1);
        for (int i = 2; i < n; i++) {
            map.put(i, map.get(i - 1) + map.get(i - 2));
        }
        return map.get(n - 1);
    }

    //f(n)=f(n-1)+f(n-2)
    //求斐波那契数列的第n项：动态规划
    public class Solution {
        public int fib3(int n) {
            //特殊输入：一定要有这个判断
            if (n <= 0) return 0;
            //边界条件:
            if (n <= 2) return 1;
            //定义指针
            int f1 = 1;
            int f2 = 1;
            //使用一个变量来保存结果即可,由于每个结果只使用1次因此可以覆盖
            int temp = 0;
            for (int i = 3; i <= n; i++) {
                //移动指针f1和f2
                temp = f1 + f2;
                f1 = f2;
                f2 = temp;
            }
            return f2;
        }
    }
}
