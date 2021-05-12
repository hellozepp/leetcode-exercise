package suanfa.leetcode;

//给定一个有序数组，对数组中的元素去重，使得原数组的每个元素只有一个。返回去重后数组的长度值。
public class a26UniqueNum {
    public int solution1(int[] arr) {
        int insert = 1;
        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != temp) {
                arr[insert++] = arr[i];
                temp = arr[i];
            }
        }
        return insert;
    }

    // 解的不对，当成无序数组了
    public int solution(int[] arr) {
        int k = 0;
        int size = 1;
        for (int i = 1; i < arr.length; i++) {
            k = 0;
            int e = arr[i];
            int j = i;
            for (; j > 0 && arr[j - 1] != e; j--) {
                if (j != k) {
//                    AlgorUtils.swap(arr, k++, j);
                    arr[j] = arr[k++];
                } else {
                    k++;
                }

                if (j - 1 == 0) {
                    size++;
                }
            }
            arr[j] = e;
        }
        return size;
    }


    public static void main(String[] args) {
//        int[] arr = {1, 3, 5, 7, 7, 7, 9, 7, 9,9,9,9,9,1,9,9};
        int[] arr = {1, 3, 5, 7, 7, 7, 9, 9, 9, 9, 9, 9, 9, 9};
        int solution = new a26UniqueNum().solution1(arr);
        System.out.println(solution);
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
