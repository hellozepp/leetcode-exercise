package leetcodeAll.leetcode3;

/**
 * 204. Count Primes
 */
public class CountPrimes {
    public int countPrimes(int n) {
        if (n <= 2)
            return 0;
        int up = (int) Math.sqrt(n);
        int cnt = n / 2;
        boolean[] state = new boolean[n];
        for (int i = 3; i <= up; i += 2) {
            if (!state[i]) {
                for (int j = i * i; j < n; j += 2 * i)
                    if (!state[j]) {
                        state[j] = true;
                        cnt--;
                    }
            }
        }
        return cnt;
    }

    //----------------solution3---------------------
    public int countPrimes3(int n) {
        if (n <= 2)
            return 0;
        int up = (int) Math.sqrt(n);
        boolean[] state = new boolean[n];
        int cnt = 1;
        for (int i = 3; i < n; i += 2) {
            if (!state[i]) {
                cnt++;
                if (i <= up)
                    for (int j = i * i; j < n; j += 2 * i)
                        state[j] = true;
            }
        }
        return cnt;
    }

    //--------------------solution2---------------
    public int countPrimes2(int n) {
        if (n <= 2)
            return 0;
        int cnt = 1;
        for (int i = 3; i < n; i++)
            if (isPrime(i))
                cnt++;
        return cnt;
    }

    private boolean isPrime(int m) {
        int mm = (int) Math.sqrt(m);
        for (int i = 2; i <= mm; i++)
            if (m % i == 0)
                return false;
        return true;
    }
}
