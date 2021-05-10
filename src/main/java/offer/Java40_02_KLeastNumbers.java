/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题40：最小的k个数
 * // 题目：输入n个整数，找出其中最小的k个数。例如输入4、5、1、6、2、7、3、8
 * // 这8个数字，则最小的4个数字是1、2、3、4。
 */
package offer;

import java.util.*;

/**
 * 最小的 K 个数
 */
public class Java40_02_KLeastNumbers {
    public ArrayList<Integer> GetLeastNumbers_Solution1(int[] input, int k) {
        if (input == null || input.length == 0 || k <= 0 || k > input.length) {
            return new ArrayList<>();
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // o2大，升序
                return o2 - o1;
            }
        });  //注意
        for (int n : input) {
            maxHeap.offer(n);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        return new ArrayList<>(maxHeap);
    }

    /** 基于堆或者红黑树的解法 */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> leastNum = new ArrayList<Integer>();
        if (input == null || input.length < 1 || k < 1 || k > input.length) {
            return leastNum;
        }
        TreeSet<Integer> kSet = new TreeSet<Integer>();
        for (int i = 0; i < input.length; i++) {
            if (kSet.size() < k) {
                kSet.add(input[i]);
            } else {
                if (input[i] < kSet.last()) {
                    kSet.remove(kSet.last());
                    kSet.add(input[i]);
                }
            }
        }
        Iterator<Integer> iterator = kSet.iterator();
        while (iterator.hasNext()) {
            leastNum.add(iterator.next());
        }
        return leastNum;
    }

    /**
     * 快速选择，partition，只有当允许修改数组元素时才可以使用
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> getLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (input == null || input.length == 0 || k <= 0 || k > input.length) {
            return res;
        }
        int low = 0;
        int high = input.length - 1;
        int idx = partition(input, low, high);
        while (idx != k - 1) {  //注意
            if (idx < k - 1) {
                low = idx + 1;
            } else {
                high = idx - 1;
            }
            idx = partition(input, low, high);
        }
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    private int partition(int[] input, int i, int j) {
        int pivot = input[i];
        while (i < j) {
            while (i < j && input[j] >= pivot) {
                j--;
            }
            input[i] = input[j];
            while (i < j && input[i] <= pivot) {
                i++;
            }
            input[j] = input[i];
        }
        input[i] = pivot;
        return i;
    }


}
