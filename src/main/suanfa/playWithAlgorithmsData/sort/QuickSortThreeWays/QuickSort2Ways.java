package suanfa.playWithAlgorithmsData.sort.QuickSortThreeWays;

import suanfa.AlgorUtils;

public class QuickSort2Ways {

    // 我们的算法类不允许产生任何实例
    private QuickSort2Ways() {
    }

    // 双路快速排序的partition
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r) {
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        swap(arr, l, (int) (Math.random() * (r - l + 1)) + l);

        Comparable v = arr[l];

        // arr[l+1...i) <= v; arr(j...r] >= v
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[i].compareTo(v) < 0) //相等的时候也swap避免偏斜
                i++;
            while (j >= l + 1 && arr[j].compareTo(v) > 0)
                j--;
            if (i > j)
                break;
            swap(arr, i++, j--);
        }
        swap(arr, l, j);
        for (Comparable integer : arr) {
            System.out.print(integer + ",");
        }
        System.out.println();
        return j;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {

        // 对于小规模数组, 使用插入排序
//        if (r - l <= 15) {
//            InsertionSort.sort(arr, l, r);
//            return;
//        }

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static void sort(Comparable[] arr) {

        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    // 测试 QuickSort
    public static void main(String[] args) { //ArrayIndexOutOfBoundsException: -1
        Integer arr1[] = {1, 2, 3, 4, 5, 4, 4, 5, 6, 7};
        long startTime = System.nanoTime();
        QuickSort2Ways.sort(arr1);
        long endTime = System.nanoTime();
        System.out.println(AlgorUtils.isSorted(arr1));
        System.out.println((endTime - startTime) / Math.pow(10, 9));

        //双路快速排序算法也是一个O(nlogn)复杂度的算法
//        // 可以在1秒之内轻松处理100万数量级的数据
//        int N = 1000000;
//        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
//        SortTestHelper.testSort("suanfa.playWithAlgorithmsData.sort.QuickSortThreeWays.QuickSort2Ways", arr);

        return;
    }
}