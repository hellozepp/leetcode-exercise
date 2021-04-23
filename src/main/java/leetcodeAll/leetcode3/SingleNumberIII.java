package leetcodeAll.leetcode3;

/**
 * 260. Single Number III
 */
public class SingleNumberIII {
    public int[] singleNumber(int[] nums) {
        int sum = 0, one = 0, two = 0;
        for (int num : nums)
            sum ^= num;
        sum &= -sum;
        for (int num : nums) {
            if ((sum & num) == 0)
                one ^= num;
            else
                two ^= num;
        }
        return new int[]{one, two};
    }
}
