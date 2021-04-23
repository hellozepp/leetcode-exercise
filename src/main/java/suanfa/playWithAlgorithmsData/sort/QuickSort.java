package suanfa.playWithAlgorithmsData.sort;

import suanfa.AlgorUtils;

/**
 * 两种快拍:
 * 1.哨兵不停动态切换,最终停在某个位置分割左右partition
 * 2.哨兵固定,左右分部与哨兵比较然,最后l指针和哨兵swap
 */
public class QuickSort {
    public static void main(String[] args) {

//        int N = 1000000;
//        Integer[] arr = SortTestHelper.generateRandomArray(N, 0, 100000);
//        SortTestHelper.testSortInt("suanfa.playWithAlgorithmsData.sort.QuickSort", arr);

        Integer arr1[] = {1, 2, 3, 4, 5, 4, 4, 5, 6, 7};
        long startTime = System.nanoTime();
        QuickSort.sort(arr1);
        long endTime = System.nanoTime();
        System.out.println(AlgorUtils.isSorted(arr1));
        System.out.println((endTime - startTime) / Math.pow(10, 9));
    }

    public static void sort(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(Integer arr[], int l, int r) {
//        if (r - l <= 15) {
//            InsertionSort.sort(arr, l, r);
//            return;
//        }
        if (l < r) {
            int index = partition(arr, l, r);
            sort(arr, l, index - 1); //index-1 左边末尾
            sort(arr, index, r);//index 中心
        }

    }

    public static int partition(final Integer[] arr, int l, int r) {
//        if (arr == null || arr.length <= 0 || l < 0 || r >= arr.length) {
//            return 0;
//        }
        final int prio = arr[l + (r - l) / 2];//优先级;
        do {
            while (arr[l] < prio)
                l++;
            while (arr[r] > prio)//等于prio哨兵在下面swap,避免偏斜
                r--;
            if (l <= r) { //等于会让指针交错造成 递归结束条件  l < 0 || r >= arr.length
                swap(arr, l++, r--);
            }
        } while (l <= r); //让左右相等进去指针交错
        return l;
    }

    //标准写法
    private static int partition(int[] arr, int l, int r) {
        int temp = arr[l];
        while (l < r) {
            // 先判断基准数和后面的数依次比较
            while (temp <= arr[r] && l < r) {
                --r;
            }
            // 当基准数大于了 arr[right]，则填坑
            if (l < r) {
                arr[l] = arr[r];
                ++l;
            }
            // 现在是 arr[l] 需要填坑了
            while (temp >= arr[l] && l < r) {
                ++l;
            }
            if (l < r) {
                arr[r] = arr[l];
                --r;
            }
        }
        arr[l] = temp;
        return l;
    }

    public static void swap(Integer[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    /**
     * quickselect
     * @param arr 找第k小的元素
     * @param v
     * @return
     */
    public static int solution(Integer[] arr, int v) {
        return solution(arr, 0, arr.length - 1, v);
    }

    private static int solution(Integer[] arr, int l, int r, int v) {

        if (l < r) {
            int p = partition(arr, l, r);
            if (p == v) {
                return arr[p];
            } else if (p < v) {
                return solution(arr, p + 1, r, v);
            } else {
                return solution(arr, l, p - 1, v);
            }
        } else if (l == r)
            return arr[l];
        return -1;
    }
}
