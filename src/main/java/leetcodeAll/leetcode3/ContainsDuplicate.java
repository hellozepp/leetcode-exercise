package leetcodeAll.leetcode3;

import java.util.HashSet;
import java.util.Set;

/**
 * 217. Contains Duplicate
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for(int n: nums) {
            if(n > max) {
                max = n;
            }
            if(n < min) {
                min = n;
            }
        }
        boolean[] exist = new boolean[max - min + 1];
        for(int n: nums) {
            if(exist[n - min]) return true;
            exist[n - min] = true;
        }
        return false;
    }


    //-----------------solution2-----------------
    public boolean containsDuplicate2(int[] nums) {
        if(nums==null||nums.length<2)
            return false;
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            if(set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }
}
