package suanfa.playWithAlgorithmsData.quiz;

import suanfa.AlgorUtils;

public class quickSort {
    public static void sort(Comparable[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            sort(arr, l, p - 1);
            sort(arr, p, r);
        }
    }

    private static int partition(Comparable[] arr, int l, int r) {
        Comparable v = arr[l + (r - l) / 2];
        while (l <= r) {
            while (arr[l].compareTo(v) < 0) {
                l++;
            }
            while (arr[r].compareTo(v) > 0) {
                r--;
            }
            if (l <= r) {
                swap(arr, l, r);
                l++;
                r--;
            }
        }
        return l;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    // 测试 QuickSort
    public static void main(String[] args) {
        Integer num[] = {10, 9, 7, 6, 5, 4, 4, 3, 2, 1};
        long startTime = System.nanoTime();
        new quickSort().sort(num);
        long endTime = System.nanoTime();
        System.out.println(AlgorUtils.isSorted(num));
        System.out.println((endTime - startTime) / Math.pow(10, 9));
    }
}
