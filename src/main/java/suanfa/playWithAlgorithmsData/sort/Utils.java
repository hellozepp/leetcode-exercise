package suanfa.playWithAlgorithmsData.sort;

import java.util.List;
import java.util.Random;

public class Utils {

	public static void exchange(int[] num, int i, int min) {
		int temp = num[i];
		num[i] = num[min];
		num[min]= temp;
	}
	public static void printArr(int[] arr) {
		for (int i:arr){
			System.out.print(i+" ");
		}
		System.out.println();
	}
	public static boolean less(int i, int j) {
		return i < j ? true : false;
	}

	public static int[] generateRandomArray(int n,int rangeL,int rangeR){
		assert  n>0&&rangeL>=0&&rangeR>0&&rangeR>=rangeL:"generateRandomArray() e: parameter can not fit!";
		int[] arr = new int[n];
		Random random = new Random();
		for (int i =0; i<n;i++){
			//rangeR - rangeL + 1：当前值域范围 rangeL：偏移量
			arr[i] = random.nextInt(new Long(System.currentTimeMillis()/1000).intValue()) % (rangeR - rangeL + 1) + rangeL;
		}
		return arr;
	}
	public static Integer[] generateRandomArrayInt(int n,int rangeL,int rangeR){
		assert  n>0&&rangeL>=0&&rangeR>0&&rangeR>=rangeL:"generateRandomArray() e: parameter can not fit!";
		Integer[] arr = new Integer[n];
		Random random = new Random();
		for (int i =0; i<n;i++){
			//rangeR - rangeL + 1：当前值域范围 rangeL：偏移量
			arr[i] = random.nextInt(new Long(System.currentTimeMillis()/1000).intValue()) % (rangeR - rangeL + 1) + rangeL;
		}
		return arr;
	}

	public static void main(String[] args) {
		int[] ints = generateRandomArray(1024, 0, 100000);
		System.out.println(ints);
	}
	public static void swap(int[] arr, int x, int y){
		int temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	public static void swap(Comparable[] arr, int x, int y){
		Comparable temp = arr[x];
		arr[x] = arr[y];
		arr[y] = temp;
	}
	public static boolean isSort(int[] arr) {
		int length = arr.length;
		for (int i=0;i<length-1;i++){
			if (arr[i]>arr[i+1]){
				return false;
			}
		}
		return true;
	}
	public static boolean isSort(List<Integer> arr) {
		Integer pre = null;
		for (Integer o : arr) {
			if (pre==null){
				pre = o;
			}else {
				if (pre>o){
					return false;
				}
			}
		}
		return true;
	}
	public static boolean isSort(Comparable[] arr) {
		int length = arr.length;
		for (int i=0;i<length-1;i++){
			if (arr[i].compareTo(arr[i+1])>0){
				return false;
			}
		}
		return true;
	}
	public static boolean isSort(int[] arr,int size) {
		if (size!=arr.length){
			return false;
		}
		int length = arr.length;
		for (int i=0;i<length-1;i++){
			if (arr[i]>arr[i+1]){
				return false;
			}
		}
		return true;
	}
	public static int[] generateOrderArray(int n,int rangeL,int rangeR){
		assert  (n>0&&rangeL>=0&&rangeR>0&&rangeR>=rangeL):"generateRandomArray() e: parameter can not fit!";
		int[] arr = new int[n];
		for (int i=0;i<n;i++){
			if (rangeL>=rangeR){
				arr[i] = rangeL;
			} else {
				arr[i] = rangeL++;
			}
		}
		return arr;
	}
}
