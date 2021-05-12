package suanfa.playWithAlgorithmsData.sort;

import com.alibaba.fastjson.JSON;

/**
 * 堆是具有以下性质的完全二叉树：每个结点的值都大于或等于其左右孩子结点的值，
 * 称为大顶堆；或者每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆。
 * 堆的子节点之间不分大小，大顶堆父节点大于子节点
 */
public class HeapSort {
    public void sort(Comparable[] arr) {
        int n = arr.length;
        for (int i = (n - 2) / 2; i >= 0; i--) {
            shiftDown(arr, n, i);
        }
        for (int j = n - 1; j > 0; j--) {
            swap(arr, 0, j);
            shiftDown(arr, j, 0);
        }
    }

    private void shiftDown(Comparable[] arr, int n, int i) {
        while (i * 2 + 1 < n) {
            int k = i * 2 + 1;
            if (k + 1 < n && arr[k + 1].compareTo(arr[k]) > 0) {
                k++;
            }
            if (arr[i].compareTo(arr[k]) >= 0) {
                break;
            }
            swap(arr, k, i);
            i = k;
        }
    }

    private void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // 测试 HeapSort
    public static void main(String[] args) {
        Integer[] arr = {6, 10, 10, 9, 9, 4, 8, 7, 4, 6};
        new HeapSort().sort(arr);
        System.out.println(JSON.toJSONString(arr));
    }
}
