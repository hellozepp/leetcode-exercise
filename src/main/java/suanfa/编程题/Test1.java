package suanfa.编程题;

import java.util.Arrays;

/**
 * @Author: zhanglin
 * @Date: 2018/5/16
 * @Time: 下午12:46
 */
public class Test1 {
    public static void main(String[] args) {
        int[] ints = {5, 6, 7, 8, 9, 4, 3, 2, 1};
        int i = 0;
        System.out.println((char)65);
    }

    public static int call(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[start] <= nums[mid]) {
                if (target < nums[mid] && target >= nums[start])
                    end = mid - 1;
                else
                    start = mid + 1;
            }

            if (nums[mid] <= nums[end]) {
                if (target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid - 1;
            }
        }
        return -1;
    }
}
