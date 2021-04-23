package suanfa.playWithAlgorithmsData.sort;

import suanfa.playWithAlgorithmsData.sort.Utils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by docker on 2017/10/7.
 * -ea:tree 指定启用 class tree 的 assertion， 其他类如果有 assertion 的话，这里没启用
 * -ea 启用所有的 assertion
 * <p>
 * 20
 * 30
 */
public class AlgosTester {
    public static void main(String[] args) {
        for (int i = 1; i <= 24; i++) {
            int size = new Double(Math.pow(2, i)).intValue();
//            int[] arr = Utils.generateRandomArray(size, 0, 100000);
//            int[] arr1 = Utils.generateRandomArray(size, 0, 100000);

            int[] arr = Utils.generateRandomArray(size, 1, 10000000);
            Integer[] arr1 = Utils.generateRandomArrayInt(size, 1, 10000000);

            long startTime = System.nanoTime();
//            startTime = System.currentTimeMillis();
//            IndexSort.sort(arr);
//            Quick3way.sort(arr, 0, arr.length - 1);
//            QuickSort.sort(arr,0,arr.length-1);
//            BubbleSort.sort(arr);
//            BubbleSort.bubblesort(arr);
            long endTime = System.nanoTime();
//            assert Utils.isSort(arr) : "nope!!!!!!!!!";
//            endTime = System.currentTimeMillis();
//            System.out.println("data size is 2^"+i+",Time cost: "+(endTime-startTime)*1e-9);
            System.out.println("1. data size is 2^" + i + ",Time cost: " + (endTime - startTime) / Math.pow(10, 9));
//            System.out.println("data size is 2^"+i+",Time cost: "+(endTime-startTime)/Math.pow(10,3));

            List<Integer> integers = Arrays.asList(arr1);
            long startTime1 = System.nanoTime();
//            Collections.sort(integers);
//            Quick3way.sort(arr1, 0, arr1.length - 1);
//            BucketSort.sort(arr1);
            long endTime1 = System.nanoTime();
//            assert Utils.isSort(arr1) : "nope!!!!!!!!!";
            System.out.println("2. data size is 2^" + i + ",Time cost: " + (endTime1 - startTime1) / Math.pow(10, 9));
            System.out.println("=================================");
            System.gc();
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }

    }
}
