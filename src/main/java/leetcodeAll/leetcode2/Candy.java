package leetcodeAll.leetcode2;

/**
 * 135. Candy
 */
public class Candy {

    public int candy(int[] ratings) {
        if (ratings.length < 2)
            return ratings.length;
        int len = ratings.length;
        int[] nums = new int[len];
        int sum = 0;
        nums[0] = 1;
        for (int i = 1; i < len; i++)
            nums[i] = ratings[i] > ratings[i - 1] ? 1 + nums[i - 1] : 1;
        sum += nums[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            nums[i] = ratings[i] > ratings[i + 1] ? Math.max(nums[i], 1 + nums[i + 1]) : nums[i];
            sum += nums[i];
        }
        return sum;
    }

    public int candy2(int[] ratings) {
        if (ratings == null || ratings.length < 2)
            return ratings.length;
        int len = ratings.length;
        int[] nums = new int[len];
        int sum = 0;
        if (ratings[0] <= ratings[1])
            nums[0] = 1;
        if (ratings[len - 1] <= ratings[len - 2])
            nums[len - 1] = 1;
        for (int i = 1; i < len - 1; i++)
            if (ratings[i] <= ratings[i - 1] && ratings[i] <= ratings[i + 1])
                nums[i] = 1;
        for (int i = 0; i < len; i++)
            if (nums[i] == 1) {
                for (int left = i - 1; left >= 0 && ratings[left] > ratings[left + 1]; left--)
                    nums[left] = Math.max(nums[left + 1] + 1, nums[left]);
                for (int right = i + 1; right < len && ratings[right] > ratings[right - 1]; right++)
                    nums[right] = Math.max(nums[right - 1] + 1, nums[right]);
            }
        for (int num : nums)
            sum += num;
        return sum;
    }
}
