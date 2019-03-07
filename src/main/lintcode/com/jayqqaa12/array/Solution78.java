package com.jayqqaa12.array;

import java.util.ArrayList;
import java.util.List;


/**
 * start在n上是全排列的问题,在i上是组合的问题
 * 求数组 中 所有数可能的结果集  （数组的值 不重复）组合
 * <p>
 * For example,
 * If nums = [1,2,3]
 * output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 *
 * @REVIEW
 * 难度2星
 */
public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {

        List list  =new ArrayList<>();
        dfs(list, new ArrayList(), nums, 0);

        return  list;
    }

    private void dfs(List list, ArrayList subList, int[] nums, int start) {

        list.add(new ArrayList<>(subList));

        for (int i = start; i < nums.length; i++) {//退出条件结合在nums.length
            subList.add(nums[i]);
            System.out.println("start:"+start+",i:"+i+",subList:"+subList);
            dfs(list, subList, nums, i + 1);
            subList.remove(subList.size() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution78().subsets(new int[]{1,2,3}));
//      [[], [1], [1, 2], [1, 2, 3], [1, 3], [2], [2, 3], [3]]
    }
}