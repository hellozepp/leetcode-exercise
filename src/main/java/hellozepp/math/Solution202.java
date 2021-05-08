package hellozepp.math;


/**
 *  编写一个算法来判断一个数是不是“快乐数”。
 *
 *  一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，
 *  也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 *  示例:
 *
 *  输入: 19
 *  输出: true
 *  解释:
 *  1^2 + 9^2 = 82
 *  8^2 + 2^2 = 68
 *  6^2 + 8^2 = 100
 *  1^2 + 0^2 + 0^2 = 1
 * <p>
 *
 * 难度 2星
 *
 *
 * FIXME
 *
 */
public class Solution202 {

    public boolean isHappy(int n) {
        int x = n, y = n;

        while (x != 1) {
            x = cal(x);
            if (x == 1) return true;
            y = cal(cal(y));
            if (y == 1) return true;
            if (x == y) return false;
        }

        return true;
    }

    public int cal(int n) {
        int s = 0;
        while (n > 0) {
            s = s + (n % 10) * (n % 10);
            n = n / 10;
        }
        return s;
    }

    public static void main(String[] args) {
        System.out.println(new Solution202().isHappy(0));
        System.out.println(new Solution202().isHappy(19));
    }
}