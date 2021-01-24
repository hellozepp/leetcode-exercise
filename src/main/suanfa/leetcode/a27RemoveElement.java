package suanfa.leetcode;

import suanfa.AlgorUtils;

public class a27RemoveElement {
    public int solution(int[] arr,int val){
        int k=0;
        for (int i=0;i<arr.length;i++){
            if (arr[i]!=val){
                AlgorUtils.swap(arr,i,k++);
            }
        }
        return k-1+1;//元素为k-1的位置
    }
    public static void main(String[] args) {
        int arr[] = {1,3,5,7,7,7,9,7,9};
        arr = new int[]{};
        arr = new int[]{10};
        int solution = new a27RemoveElement().solution(arr, 7);
        solution = new a27RemoveElement().solution(arr, 10);
        System.out.println(solution);
        for (int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();

    }
}
