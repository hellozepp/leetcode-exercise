package leetcodeAll.leetcode2;

import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int pre = nums[0], cnt = 0;
        for (int num : nums) {
            if (cnt == 0)
                pre = num;
            if (num == pre)
                cnt++;
            else
                cnt--;
        }
        return pre;
    }

    public int majorityElement3(int[] nums) {
        int[] p = partition(nums, 0, nums.length - 1);
        while (p[1] - p[0] + 1 <= nums.length / 2) {
            if (p[0] > nums.length / 2)
                p = partition(nums, 0, p[0] - 1);
            else
                p = partition(nums, p[1] + 1, nums.length - 1);
        }
        return nums[p[0]];
    }

    private int[] partition(int[] nums, int left, int right) {
        int less = left - 1, more = right;
        while (left < more) {
            if (nums[left] < nums[right])
                swap(nums, left++, ++less);
            else if (nums[left] > nums[right])
                swap(nums, left, --more);
            else
                left++;
        }
        swap(nums, more, right);
        return new int[]{less + 1, more};
    }

    private void swap(int[] nums, int left, int right) {
        if (left != right) {
            nums[left] = nums[left] ^ nums[right];
            nums[right] = nums[left] ^ nums[right];
            nums[left] = nums[left] ^ nums[right];
        }
    }

    public int majorityElement2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int num : nums) {
            if (!map.containsKey(num))
                map.put(num, 1);
            else
                map.put(num, map.get(num) + 1);
            if (map.get(num) > len / 2)
                return num;
        }
        return -1;
    }
}
