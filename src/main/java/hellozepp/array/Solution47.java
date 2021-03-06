package hellozepp.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 同no.46
 * 不同之处在与 数组数字可能相同
 * 难度 2.5星
 *
 * @REVIEW
 */
public class Solution47 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List list = new ArrayList<>();

        Arrays.sort(nums);
        boolean[] visited = new boolean[nums.length];
        dfs(list, new ArrayList(), nums, visited);

        return list;
    }


    private void dfs(List list, ArrayList subList, int[] nums, boolean[] visits) {

        if (subList.size() == nums.length) {
            System.out.println("add a subList:"+subList);
            list.add(new ArrayList<>(subList));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visits[i]) continue;

            if (i > 0 && nums[i] == nums[i - 1] && !visits[i - 1]) {//visits[i - 1] 当前发现重复则不会再次进入dfs,因为i-1为刚删除的
                System.out.println("visits[i - 1]:"+visits[i - 1]+",i - 1:"+(i - 1)+",nums[i - 1]:"+nums[i - 1]+",nums[i]:"+nums[i]);
                continue; //关键一句 判断 i-1的是否相同 过滤掉重复的排序
            }

            visits[i] = true;
            subList.add(nums[i]);
            dfs(list, subList, nums, visits);
            System.out.println("i:"+i+",remove:"+subList.get(subList.size() - 1));
            subList.remove(subList.size() - 1);
            visits[i] = false;
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution47().permuteUnique(new int[]{1, 2, 1}).toString());
//       [[1, 1, 2], [1, 2, 1], [2, 1, 1]]
    }
}