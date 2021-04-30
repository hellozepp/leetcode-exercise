package suanfa.interview;

/**
 * @Author: zhanglin
 * @Date: 2021/4/29
 * @Time: 5:36 PM
 */
public class 递归实现乘法 {
    public static void main(String[] args) {
        System.out.println(new 递归实现乘法().func(12, 13));
    }

    public int func(int x, int y) {
        return func(x, y, x);
    }

    public int func(int x, int y, int i) {
        if (y == 1) {
            return x;
        }
        return func(i + x, y - 1, i);
    }

}
