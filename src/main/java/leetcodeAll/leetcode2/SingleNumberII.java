package leetcodeAll.leetcode2;

/**
 * 137. Single Number II
 */
public class SingleNumberII {
    public int singleNumber(int[] nums) {
        int a = 0, b = 0;
        for (int num : nums) {
            a = (a ^ num) & ~b;
            b = (b ^ num) & ~a;
        }
        return a;
    }

    public int singleNumber2(int[] nums) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int tmp = 0;
            for (int j = 0; j < nums.length; j++) {
                tmp += (nums[j] >> i) & 1;
            }
            res |= (tmp % 3) << i;
        }
        return res;
    }
}
