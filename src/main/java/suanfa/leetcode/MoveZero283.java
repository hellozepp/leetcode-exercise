package suanfa.leetcode;
//数组所有0挪到末尾

import suanfa.AlgorUtils;

public class MoveZero283 {
    public void moveZero(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        int k = 0;//k->[0:k) 非0值的元素
        //[0:i]所有非零元素排在0:k)之间保持有序
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                if (i != k) {
                    AlgorUtils.swap(arr, k++, i);
                } else {
                    k++;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};

        (new MoveZero283()).moveZero(arr);

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
