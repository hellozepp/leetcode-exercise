package suanfa.playWithAlgorithmsData.sort;

import suanfa.AlgorUtils;

/**
 * 两种快拍:
 * 1.哨兵不停动态切换,最终停在某个位置分割左右partition
 * 2.哨兵固定,左右分部与哨兵比较然,最后l指针和哨兵swap
 *
 * 只看这个解法即可
 */
public class QuickSort {
    public static void main(String[] args) {
        Integer arr1[] = {1, 2, 3, 4, 5, 4, 4, 5, 6, 7, 101};
        long startTime = System.nanoTime();
        QuickSort.sort(arr1);
        long endTime = System.nanoTime();
        System.out.println(AlgorUtils.isSorted(arr1));
        System.out.println((endTime - startTime) / Math.pow(10, 9));

        startTime = System.nanoTime();
        QuickSort.sort1(arr1);
        endTime = System.nanoTime();
        System.out.println(AlgorUtils.isSorted(arr1));
        System.out.println((endTime - startTime) / Math.pow(10, 9));

        arr1 = new Integer[]{3, 3, 3, 3, 3};
        QuickSort.sort(arr1);
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
        if (l >= r) {
            return;
        }
        int index = partition(arr, l, r);
        sort(arr, l, index - 1);
        sort(arr, index, r);

    }

    public static int partition(final Integer[] arr, int l, int r) {
        final int prior = arr[l + (r - l) / 2];
        do {
            while (arr[l] < prior) {
                l++;
            }
            //等于prio哨兵在下面swap,避免偏斜
            while (arr[r] > prior) {
                r--;
            }
            // 调用的sort保证 l r 不会越界，所以用do while
            if (l <= r) {
                //等于会让指针交错造成 递归结束条件,否则会死循环  l < 0 || r >= arr.length
                swap(arr, l++, r--);
            }
        } while (l <= r); // 让左右相等的进去指针交错
        return l;
    }

    public static void swap(Integer[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    /* --------------------------标准写法----------------------*/
    public static void sort1(Comparable[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(Comparable[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(Comparable[] arr, int l, int r) {
        if (l < r) {
            int p = partition(arr, l, r);
            sort(arr, l, p - 1);
            sort(arr, p, r);
        }
    }

    private static int partition(Comparable[] arr, int l, int r) {
        Comparable v = arr[l + (r - l) / 2];
        while (l <= r) {
            while (arr[l].compareTo(v) < 0) {
                l++;
            }
            while (arr[r].compareTo(v) > 0) {
                r--;
            }
            if (l <= r) {
                swap(arr, l++, r--);
            }
        }
        return l;
    }

    private static void swap(Object[] arr, int i, int j) {
        Object tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
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
