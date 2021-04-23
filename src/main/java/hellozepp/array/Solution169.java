package hellozepp.array;


import java.util.HashMap;
import java.util.Map;

/**
 * 求众数——分治
 * 找到出现次数超过 一半的数
 * <p>
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * <p>
 * 你可以假设数组是非空的，并且数组中的众数永远存在。
 * 难度1星
 */
public class Solution169 {


    /**
     * 最优解
     *
     * @param num
     * @return
     */
    public int majorityElement(int[] num) {

        int major = num[0], count = 1;//major:主要的 投票最多的获胜
        for (int i = 1; i < num.length; i++) {
            if (count == 0) {
                count++;
                major = num[i];
            } else if (major == num[i]) count++;
            else count--;

        }
        return major;
    }

    /**
     * 思路1 最好想到
     *
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(nums[i]))
                map.put(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);

            if (map.get(nums[i]) > nums.length / 2) return nums[i];
        }
        return -1;
    }


}