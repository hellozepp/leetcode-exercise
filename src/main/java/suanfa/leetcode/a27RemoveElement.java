package suanfa.leetcode;

import suanfa.AlgorUtils;

/**
 *  给定一个数组和一个值，在这个数组中原地移除指定值和返回移除后新的数组长度。
 *
 *  不要为其他数组分配额外空间，你必须使用 O(1) 的额外内存原地修改这个输入数组。
 *
 *  元素的顺序可以改变。<b>超过返回的新的数组长度以外的数据无论是什么都没关系。</b>
 *
 *
 * 难度 1星
 * 双指针求解，l为慢指针，r为快指针
 * l含义是不包括l的区间的值为检测过
 */
public class a27RemoveElement {
    public int solution(int[] arr, int val) {
        int r = 0;
        for (int l = 0; l < arr.length; l++) {
            if (arr[l] != val) {
                AlgorUtils.swap(arr, l, r++);
            }
        }
        return r - 1 + 1;//元素为k-1的位置
    }

    public static void main(String[] args) {
        int arr[] = {1, 3, 5, 7, 7, 7, 9, 7, 9};
//        arr = new int[]{};
//        arr = new int[]{10};
        int solution = new a27RemoveElement().solution(arr, 7);
        System.out.println(solution);
        solution = new a27RemoveElement().solution(arr, 10);
        System.out.println(solution);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
