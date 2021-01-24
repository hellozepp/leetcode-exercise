package suanfa.playWithAlgorithmsData.动态规划;

/**
 * @Author: zhanglin
 * @Date: 2018/5/8
 * @Time: 上午10:41
 */
public class test {
    public static void main(String[] args) {
        System.out.println(System.nanoTime());
        System.out.println("--------"+fun(100));
        System.out.println(System.nanoTime());
        System.out.println(System.nanoTime());
        System.out.println("--------"+fun1(100));
        System.out.println(System.nanoTime());

    }

    public static int fun(int m) {
        if (m <= 1) return -1;
        if (m == 1) return 0;
        if (m == 2) return 1;
        int a = 0;
        int b = 1;
        for (int i = 0; i < m - 2; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }

    static int fun1(int m) {
        if (m > 2) {
            return m = fun1(m - 1) + fun1(m - 2);
        } else if (m == 2) {
            return 1;
        } else {
            return 0;
        }
    }

}
