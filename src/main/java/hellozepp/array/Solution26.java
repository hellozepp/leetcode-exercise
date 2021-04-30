package hellozepp.array;


/**
 *
 * 删除重复字符串 （数组已排序）
 *给定一个有序数组，删除重复内容，使每个元素只出现一次，并返回新的长度。
 *
 * 不要为其他数组分配额外的空间，您必须通过在 O（1）额外的内存中就地修改输入数组来实现这一点。
 *
 * 例：
 *
 * 给定nums = [1,1,2]，
 *
 * 你的函数应该返回length = 2，前两个nums元素分别是1和2。
 * 无论你离开新的长度，都没有关系。
 *
 * 难度2星
 *
 * FIXME
 *
 */
public class Solution26 {

    public int removeDuplicates(int[] nums) {

        if (nums.length < 2) return nums.length;

        int c = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) nums[c++] = nums[i];
        }

        return c;
    }

}