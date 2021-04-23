package contest;

/**
 * contest-100
 */
public class Contest100 {

    /**
     * 896. Monotonic Array
     */
    public static class MonotonicArray {
        public boolean isMonotonic(int[] A) {
            if (A == null || A.length < 2)
                return true;
            int i = 1;
            while (i < A.length && A[i] == A[i - 1])
                i++;
            if (i == A.length)
                return true;
            if (A[i] > A[i - 1]) {
                for (; i < A.length; i++)
                    if (A[i] < A[i - 1])
                        return false;
            } else {
                for (; i < A.length; i++)
                    if (A[i] > A[i - 1])
                        return false;
            }
            return true;
        }
    }
}
