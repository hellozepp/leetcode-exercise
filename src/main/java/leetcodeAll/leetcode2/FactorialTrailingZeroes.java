package leetcodeAll.leetcode2;

/**
 * 172. Factorial Trailing Zeroes
 */
public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        if (n < 5)
            return 0;
        return n / 5 + trailingZeroes(n / 5);
    }

    public int trailingZeroes2(int n) {
        int res = 0;
        while (n > 4) {
            n /= 5;
            res += n;
        }
        return res;
    }
}
