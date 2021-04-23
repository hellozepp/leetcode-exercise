package suanfa.playWithAlgorithmsData.sort.heapsort.quiz;

import suanfa.playWithAlgorithmsData.sort.Utils;

public class HeapsortTest {
    public static void sort(Comparable[] arr) {//对初始堆进行 heapify
        int n = arr.length;
        for (int j = (n - 1 - 1) / 2; j >= 0; j--) {//选定最后一个飞叶子 最小值为0的堆,故n-2
            __shiftDown(arr, n, j);
        }
        //弹出堆顶
        for (int i = n - 1; i > 0; i--) {
            Utils.swap(arr, 0, i);
            __shiftDown(arr, i, 0);//减掉一个index->i-1，还剩i个元素
        }
    }

    private static void __shiftDown(Comparable[] arr, int n, int j) {
        Comparable p = arr[j];
        while (j * 2 + 1 < n) {//2j 变 2j+1
            int k = j * 2 + 1;
            if (k + 1 < n && arr[k + 1].compareTo(arr[k]) > 0) {
                k++;
            }
            if (p.compareTo(arr[k]) >= 0) {
                break;
            }
            arr[j] = arr[k]; //上移替换swap
            j = k;
        }
        arr[j] = p;
    }

    public static void main(String[] args) {

        int N = 11;
        Integer[] arr = {6, 10, 10, 9, 9, 4, 8, 7, 4, 6, 11};
        sort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println(Utils.isSort(arr));
    }
}
