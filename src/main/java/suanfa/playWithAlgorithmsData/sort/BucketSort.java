package suanfa.playWithAlgorithmsData.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class BucketSort {

    public static void sort(int[] arr) {
        System.out.println();
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        //桶数
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<List<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }

        //将每个元素放入桶
        for (int i = 0; i < arr.length; i++) {
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }
        //对每个桶进行排序
        for (int i = 0; i < bucketArr.size(); i++) {
            if (bucketArr.get(i).size() > 0)
                Collections.sort(bucketArr.get(i));

        }
        //对每个桶还原到原数组
        int j = 0;
        for (int i = 0; i < bucketArr.size(); i++) {
            if (bucketArr.get(i).size() > 0) {
                for (Integer integer : bucketArr.get(i)) {
                    arr[j++] = integer;
                }
            }
        }
        System.out.println();
    }

    // 对arr[l...r]的区间使用InsertionSort排序
    public static void insertionSort(Comparable[] arr, int l, int r) {
        if (arr == null || arr.length < 2 || r < l) {
            return;
        }
        for (int i = l + 1; i <= r; i++) {
            Comparable e = arr[i];
            int j = i;
            for (; j > l && arr[j - 1].compareTo(e) > 0; j--)
                arr[j] = arr[j - 1];
            arr[j] = e;
        }
    }

    // 对arr[l...r]的区间使用InsertionSort排序
    public static void insertionSort(int[] arr, int l, int r) {

        for (int i = l + 1; i <= r; i++) {
            int e = arr[i];
            int j = i;
            for (; j > l && arr[j - 1] > e; j--)
                arr[j] = arr[j - 1];
            arr[j] = e;
        }
    }


    private int[] buckets;
    private int[] arrays;


    public BucketSort(int range, int[] arrays) {

        this.buckets = new int[range];
        this.arrays = arrays;
    }

    public void sort() {
        if (arrays != null && arrays.length > 1) {
            for (int i = 0; i < arrays.length; i++) {
                buckets[arrays[i]]++;
            }
        }
    }

    public void print() {
        for (int i = buckets.length - 1; i >= 0; i--) {
            for (int j = 0; j < buckets[i]; j++) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] num = {4, 1, 2, 5, 9, 6, 7, 5};
        int range = 10;
        BucketSort bucketSort = new BucketSort(10, num);
        bucketSort.sort();
        bucketSort.print();
    }
}
