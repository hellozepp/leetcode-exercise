package suanfa.playWithAlgorithmsData.sort.test;

import suanfa.playWithAlgorithmsData.sort.heapsort.SortTestHelper;
import suanfa.AlgorUtils;

import java.util.Random;

import static suanfa.AlgorUtils.*;

public class Quiz {
    public void sort(Integer[] arr){
        sort(arr,0,arr.length-1);
    }
    /**
     * @param arr
     * @param l
     * @param r
     */
    private void sort(Integer[] arr, int l, int r){
        if (r<=l){
            return;
        }
        swap(arr,l,new Random().nextInt(r-l+1)+l);
        int v= arr[l];
        int lt=l;
        int gt=r+1;
        int i=l+1;
        while (i<gt){
            if (arr[i]<v){
                swap(arr,i++,++lt);
            }else if (arr[i]>v){
                swap(arr,i,--gt);
            }else {
                i++;
            }
        }
        swap(arr,l,lt);
        sort(arr,l,lt-1);
        sort(arr,gt,r);
    }

    public static void main(String[] args) {
         // 三路快速排序算法也是一个O(nlogn)复杂度的算法
        // 可以在1秒之内轻松处理100万数量级的数据
        int N = 1000000;
        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
        new Quiz().sort(arr);
        System.out.println(AlgorUtils.isSorted(arr));
    }
}
