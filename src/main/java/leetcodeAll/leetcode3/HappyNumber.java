package leetcodeAll.leetcode3;

import java.util.HashSet;

/**
 * 202. Happy Number
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        if (n < 10) {
            if (n == 1 || n == 7)
                return true;
            return false;
        }
        int sum = 0, mod = 0;
        while (n != 0) {
            mod = n % 10;
            n /= 10;
            sum += mod * mod;
        }
        return isHappy(sum);
    }

    //---------------------------solution2-----------------
    public boolean isHappy2(int n) {
        if (n <= 0 || String.valueOf(n).charAt(0) == '0')
            return false;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 1; i < 10; i++)
            set.add(i);
        while (!set.contains(n)) {
            set.add(n);
            n = getSquares(n);
        }
        if (n == 1 || n == 7)
            return true;
        return false;
    }

    private int getSquares(int n) {
        int res = 0;
        while (n != 0) {
            int tmp = n % 10;
            n /= 10;
            res += tmp * tmp;
        }
        return res;
    }
}
