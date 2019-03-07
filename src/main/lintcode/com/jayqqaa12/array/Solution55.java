package com.jayqqaa12.array;

/**
 * 你开始在 index 0
 * 数组数字代表移动的最大距离
 * 看看是否能到底 最后应该元素
 * <p>
 * 难度2星
 */
public class Solution55 {

/**
 * Jump Game 给你一个数组，数组的每个元素表示你能前进的最大步数，最开始时你在第一个元素所在的位置，之后你可以前进，问能不能到达最后一个元素位置。
 *
 * 比如：
 *
 * A = [2, 3, 1, 1, 4], return true.
 * 一种走法是 0 - 2 - 3 - 4，还有一种走法是 0 - 2 - 1 - 1 - 4
 *
 * Question:
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 *
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * Example 2:
 *
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 *              jump length is 0, which makes it impossible to reach the last index.
 * */

    public boolean canJump(int[] nums) {

        int max = 0;
        for(int i=0;i<nums.length;i++){
            if(i>max) return false;
            max = Math.max(nums[i]+i,max);//index(已走步数)+num[i](当前可走最大)
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution55().canJump(new int[]{2,3,1,1,4}));
        System.out.println(new Solution55().canJump(new int[]{3,2,1,0,4}));
    }

}