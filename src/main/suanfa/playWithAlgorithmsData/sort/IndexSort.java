package suanfa.playWithAlgorithmsData.sort;


/**
 * Created by docker on 2017/10/7.
 * 29次方溢出 java.lang.OutOfMemoryError: Java heap space
 */
public class IndexSort {
    public static void main(String[] args) {
        int num[] = {7, 3, 5, 4, 1123, 6, 8, 8, 7};
        int size = num.length;
//        int num[] = {10,9,7,6,5,4,4,3,2,1 };
        long startTime = System.nanoTime();
        sort(num);
        long endTime = System.nanoTime();
        System.out.println(Utils.isSort(num, size));
        System.out.println((endTime - startTime) / Math.pow(10, 9));
        //打印
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println();
    }

    public static int[] sort(int[] num) {
        int length = num.length;
        int MAX_VALUE = Integer.MIN_VALUE;
        for (int i = 0; i < length; i++) {
            if (num[i] > MAX_VALUE) {
                MAX_VALUE = num[i];
            }
        }

        Integer[] list = new Integer[MAX_VALUE + 1];
        for (int i = 0; i < length; i++) {
            if (list[num[i]] == null) {
                list[num[i]] = 1;
            } else {
                list[num[i]] = list[num[i]] + 1;
            }
        }
        int j = 0;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                while (list[i] != 0) {
                    num[j++] = i;
                    list[i]--;
                }
            }
        }
        return num;
    }
}