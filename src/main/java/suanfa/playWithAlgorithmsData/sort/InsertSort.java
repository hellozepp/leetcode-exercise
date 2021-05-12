package suanfa.playWithAlgorithmsData.sort;

public class InsertSort {
    public static void main(String[] args) {
        int num[] = {3, 1, 5, 4, 123, 55, 33, 123, 2};
        new InsertSort().sort(num);
        for (int n : num) {
            System.out.print(n + " ");
        }
    }

    //	外循环控制指针下移，内循环从当前位置向前(<-)比交，小就交换，否则退出内循环。（从后面找牌往前插，再往后再查）
    void sort(int num[]) {
        for (int i = 1; i < num.length; i++) {
            for (int j = i; j > 0 && Utils.less(num[j], num[j - 1]); j--) {
                Utils.exchange(num, j, j - 1);
            }
        }
    }

}
