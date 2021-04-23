package leetcodeAll.leetcode2;

/**
 * 167. Two Sum II - Input array is sorted
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0, right = numbers.length - 1;
        while (true) {
            if (numbers[left] + numbers[right] == target)
                return new int[]{left + 1, right + 1};
            if (numbers[left] + numbers[right] > target)
                right--;
            else
                left++;
        }
    }
}
