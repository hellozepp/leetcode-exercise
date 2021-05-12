package suanfa.playWithAlgorithmsData.sort;

/**
 * @author Administrator
 * 内循环设置一个公共变量记录最小值，每次遍历找最小值与当前位置交换
 */
public class SelectSort {
    public static void main(String[] args) {
        int num[] = {3, 1, 5, 4, 123, 55, 33, 123};
        new SelectSort().sort(num);
        for (int n : num) {
            System.out.print(n + " ");
        }
    }

    void sort(int num[]) {
        for (int i = 0; i < num.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < num.length; j++) {
                if (num[j] < num[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                Utils.exchange(num, i, minIndex);
            }
        }
    }
}
