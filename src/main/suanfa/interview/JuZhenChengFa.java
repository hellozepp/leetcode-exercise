package suanfa.interview;

public class JuZhenChengFa {


    public static void main(String[] args) {
        final int N = 5;
        int a[][] = new int[N][N];
        int b[][] = new int[N][N];
        int c[][] = new int[N][N];
        /************初始化数组a的元素**************/
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                a[i][j] = (int) ((Math.random() * 10000) % 11 + 5);
            }
        }
        /************初始化数组b的元素**************/
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                b[i][j] = (int) ((Math.random() * 10000) % 11 + 5);
            }
        }
        /************矩阵乘法得到矩阵c**************/
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                for (int k = 0; k < a.length; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                    /**
                     * 00 00 = 00
                     * 01 10 = 00
                     * 02 20 = 00
                     *
                     * 00 01 = 01
                     * 01 11 = 01
                     * 02 21 = 01
                     * */
                }
            }
        }
        /************输出矩阵a的元素**************/
        System.out.println("输出矩阵a：");
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                System.out.printf("%d", a[i][j]);
                if (j == 4) {
                    System.out.println();
                } else {
                    System.out.print(",");
                }
            }
        }
        /************输出矩阵b的元素**************/
        System.out.println("输出矩阵b：");
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b.length; j++) {
                System.out.printf("%d", b[i][j]);
                if (j == 4) {
                    System.out.println();
                } else {
                    System.out.print(",");
                }
            }
        }
        /************输出矩阵b的元素**************/
        System.out.println("输出矩阵相乘得到的矩阵c：");
        for (int i = 0; i < c.length; i++) {
            for (int j = 0; j < c.length; j++) {
                System.out.printf("%d", c[i][j]);
                if (j == 4) {
                    System.out.println();
                } else {
                    System.out.print(",");
                }
            }
        }
    }
}
