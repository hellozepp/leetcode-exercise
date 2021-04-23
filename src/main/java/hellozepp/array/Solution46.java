package hellozepp.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 返回给定数组中 所有组的不同组合(数组数字 都不相同)
 * <p>
 * For example,
 * input 1,2,3
 * <p>
 * [[1,2,3],
 * [1,3,2],
 * [2,1,3],
 * [2,3,1],
 * [3,1,2],
 * [3,2,1]]
 * <p>
 * 难度 2星
 */
public class Solution46 {

    /**
     * dfs 方式最优解
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int... nums) {

        List list = new ArrayList<>();
        dfs(list, new ArrayList(), nums, 0);

        return list;
    }

    private void dfs(List list, ArrayList subList, int[] nums, int start) {

        if (start == nums.length) {
            list.add(new ArrayList<>(subList));
            System.out.println("sub list add to list:"+subList.toString());
            return;
        }
        for (int i = 0; i <= start; i++) {
            subList.add(i, nums[start]); //相当于队列
            System.out.println("add to subList["+i+"]:"+nums[start]+",start:"+start +",current subList:"+subList);
            dfs(list, subList, nums, 1 + start);
            subList.remove(i); //pop
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution46().permute(1,2,3).toString());
//        [[3, 2, 1], [2, 3, 1], [2, 1, 3], [3, 1, 2], [1, 3, 2], [1, 2, 3]]
    }


}