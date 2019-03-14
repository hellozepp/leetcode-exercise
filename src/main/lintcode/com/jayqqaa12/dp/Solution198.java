package com.jayqqaa12.dp;


/**
 *
 * 相邻的房子不能偷 会被发现
 *
 * 求最大收益
 *
 * 难度2星
 *
 */
public class Solution198 {
    public int rob(int[] nums) {

        int rob = 0; //max monney can get if rob current house
        int notrob = 0; //max money can get if not rob current house
        for (int i = 0; i < nums.length; i++) {
            int currob = notrob + nums[i]; //if rob current value, previous house must not be robbed
            notrob = Math.max(notrob, rob); //if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
            rob = currob;
        }
        return Math.max(rob, notrob);

    }
//    动态方程：
//dp[i] = num[i] + dp[i-2] > dp[i-1] ? num[i] + dp[i-2] : dp[i - 1]
public int rob1(int[] num) {
        int[] max = new int[num.length];
        if (num == null || num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return num[0];
        }
        if(num.length==2){
            return Math.max(num[0],num[1]);
        }
        max[0]=num[0];
        max[1]=Math.max(num[0],num[1]);
        for(int i=2;i<num.length;i++)
        {
            max[i]=Math.max(max[i-1],max[i-2]+num[i]);
        }
        return max[num.length-1];
    }

}