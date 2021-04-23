package leetcodeAll.leetcode2;

/**
 * 198. House Robber
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int[] state = new int[nums.length];
        state[0] = nums[0];
        state[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            state[i] = Math.max(state[i - 2] + nums[i], state[i - 1]);
        }
        return state[nums.length - 1];
    }

    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int a = nums[0], b = 0;
        for (int i = 1; i < nums.length; i++) {
            int aa = a;
            a = nums[i] + b;
            b = Math.max(aa, b);
        }
        return Math.max(a, b);
    }
}
