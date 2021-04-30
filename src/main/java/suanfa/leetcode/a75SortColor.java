package suanfa.leetcode;

import suanfa.AlgorUtils;

public class a75SortColor {
    //给定一个有n个元素的数组，数组中元素的取值只有0, 1, 2三种可能。为这个数组排序。
    public void solution(int[] arr) {
        int[] count = new int[3];
        for (int i : arr) {
            assert i >= 0 && i <= 2;
            count[i] = count[i] + 1;
        }
        int j = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[j++] = i;
                count[i] = count[i] - 1;
            }
        }
    }

    public void solution2(int[] arr) {
        int zero = -1;
        int two = arr.length;
        for (int i = 0; i < two; ) {
            if (arr[i] == 1) {
                i++;
            } else if (arr[i] == 0) {
                AlgorUtils.swap(arr, i++, ++zero);
            } else {
                assert arr[i] == 2;
                AlgorUtils.swap(arr, i, --two);
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1, 1, 1, 2, 0, 0, 2, 1, 2};
        new a75SortColor().solution2(arr);
        System.out.println(AlgorUtils.isSort(arr));
    }
}
