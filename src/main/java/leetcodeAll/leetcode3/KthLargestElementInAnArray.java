package leetcodeAll.leetcode3;

import java.util.Arrays;

/**
 * 215. Kth Largest Element in an Array
 */
public class KthLargestElementInAnArray {
    //-----------------solution1------基于随机快排----2ms--
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k - 1);
    }

    private int findKthLargest(int[] nums, int left, int right, int k) {
        swap(nums, (int) ((right - left) * Math.random()) + left, right);
        int[] p = partition(nums, left, right);
        if (p[0] <= k && k <= p[1])
            return nums[p[0]];
        else if (p[0] > k)
            return findKthLargest(nums, 0, p[0] - 1, k);
        else
            return findKthLargest(nums, p[1] + 1, right, k);
    }

    private int[] partition(int[] nums, int left, int right) {
        int more = left - 1, less = right;
        while (left < less) {
            if (nums[left] > nums[right])
                swap(nums, ++more, left++);
            else if (nums[left] < nums[right])
                swap(nums, left, --less);
            else
                left++;
        }
        swap(nums, less, right);
        return new int[]{more + 1, less};
    }

    private void swap(int[] nums, int left, int right) {
        if (nums[left] != nums[right]) {
            nums[left] = nums[left] ^ nums[right];
            nums[right] = nums[left] ^ nums[right];
            nums[left] = nums[left] ^ nums[right];
        }
    }

    //------------------solution2-------BFPRT算法---8ms----
    public int findKthLargest2(int[] nums, int k) {
        return findK(nums, 0, nums.length - 1, k);
    }

    public int findK(int[] arr, int lo, int hi, int k) {
        if (arr == null || arr.length == 0 || k > arr.length)
            return -1;
        if (lo >= hi)
            return arr[lo];
        int pos = getPos(arr, lo, hi); //获取标志位
        int[] p = partition(arr, lo, hi, pos);
        if (p[0] < k && k <= p[1] + 1) // 若目前所排的部分包含第k个数，则返回，否则递归排序左边或右边
            return arr[p[0]];
        else if (k <= p[0])
            return findK(arr, 0, p[0] - 1, k);
        else
            return findK(arr, p[1] + 1, hi, k);
    }

    private int getPos(int[] nums, int left, int right) {
        int[] arr5 = new int[(right - left) / 5 + 1]; // 存放切割后的多个小数组的中位数
        for (int i = left; i <= right; i += 5) {
            int size = right - i >= 4 ? 5 : right - i + 1; // 当前小数组的实际长度
            int[] tmp = new int[size];
            for (int j = 0; j < size; j++)
                tmp[j] = nums[i + j];
            Arrays.sort(tmp);
            arr5[(i - left) / 5] = tmp[(tmp.length - 1) / 2];
        }
        return findK(arr5, 0, arr5.length - 1, (arr5.length + 1) / 2); // 递归求arr5的(下)中位数
    }

    private int[] partition(int[] nums, int left, int right, int pos) {
        int more = left - 1, less = right;
        while (left <= less) {
            if (nums[left] > pos)
                swap(nums, ++more, left++);
            else if (nums[left] < pos)
                swap(nums, less--, left);
            else
                left++;
        }
        return new int[]{more + 1, less};
    }
}
