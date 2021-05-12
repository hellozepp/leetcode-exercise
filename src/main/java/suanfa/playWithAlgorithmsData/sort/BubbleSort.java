package suanfa.playWithAlgorithmsData.sort;

import suanfa.AlgorUtils;

/**
 * @author Administrator
 *         i<Length-1 轮询到倒数第二个
 *         Length-i-1 轮询到屏蔽之后的倒数第二
 */
public class BubbleSort {
    public static void main(String[] args) {
        int num[] = {7, 3, 5, 4, 1123, 6, 8, 5};
//        sort(num);
//        bubblesort(num);
        bubblesort2(num);
        for (int n : num) {
            System.out.print(n + " ");
        }
    }

    //外循环控制屏蔽元素个数 内循环从前往后冒泡，大的到屏蔽的元素前的前一个（前后比较大小）
    public static void sort(int num[]) {
        int Length = num.length;
        for (int i = 0; i < Length - 1; i++) {
            for (int j = 0; j < Length - i - 1; j++) {
                if (num[j] > num[j + 1]) {
                    Utils.exchange(num, j, j + 1);
                }
            }
        }
    }

    //优化版本
    public static void bubblesort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            boolean changeflag = true;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    changeflag = false;
                }
            }
//            printMidRes(arr);
            if (changeflag) {//从j->0开始冒到屏蔽之前都未空，则数组有序
                break;
            }

        }
    }
    //优化版本2
    public static void bubblesort2(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int max = arr.length-i;
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] >arr[max]) {
                    max=j;
                }
            }
            if (max!=arr.length-i){
                AlgorUtils.swap(arr,max,arr.length-i);
            }

        }
    }

    public static void printMidRes(int[] arr) {
        //打印内循环完成后的中间结果
        for (int j : arr) {
            System.out.print(j);
            System.out.print(",");
        }
        System.out.println("中间结果");
    }


}
