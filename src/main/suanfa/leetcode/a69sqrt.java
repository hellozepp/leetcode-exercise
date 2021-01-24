package suanfa.leetcode;

public class a69sqrt {
    public static int solution(int n) {
        int low = 0, high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid * mid < n) {
                low = mid + 1;
            } else if (mid * mid > n) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return high;
    }

    public static int mySqrt(int x) {
        long lo = 0;
        long hi = x;

        while (hi >= lo) {
            long mid = lo + (hi - lo) / 2;
            if (x < mid * mid)
                hi = mid - 1;      // not hi = mid
            else
                lo = mid + 1;
        }
        return (int) hi;
    }

    public static void main(String[] args) {
        System.out.println(solution(63));
        System.out.println(mySqrt(63));
    }
}
