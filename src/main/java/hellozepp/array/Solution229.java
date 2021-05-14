package hellozepp.array;

import java.util.ArrayList;
import java.util.List;


/**
 * 找出所有出现频率 高于 1/3 的数字
 * <p>
 * 要求 空间为 O（1）
 * 使用摩尔投票算法，高于1/3，则
 * <p>
 * FIXME
 */
public class Solution229 {

    /**
     * 跟 no.169 一样
     * <p>
     * 大于 1/3 的数字最多只能有2个
     *
     * @param nums
     * @return
     */
    public List<Integer> majorityElement(int[] nums) {

        List<Integer> list = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return list;
        }
        int c1 = 0, c2 = 0, num1 = nums[0], num2 = nums[0];

        // 先找出 最多的2个数
        for (int num3 : nums) {
            if (num1 == num3) {
                c1++;
            } else if (num2 == num3) {
                c2++;
            } else if (c1 == 0) {
                c1 = 1;
                num1 = num3;
            } else if (c2 == 0) {
                c2 = 1;
                num2 = num3;
            } else {
                c1--;
                c2--;
            }
        }

        //再统计一下 数量
        c1 = 0;
        c2 = 0;

        for (int num : nums) {
            if (num1 == num) {
                c1++;
            }
            if (num2 == num) {
                c2++;
            }
        }
        if (c1 > nums.length / 3) {
            list.add(num1);
        }
        if (c2 > nums.length / 3 && num1 != num2) {
            list.add(num2);
        }

        return list;
    }


}