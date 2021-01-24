package suanfa.playWithAlgorithmsData.动态规划;

/**
 * @Author: zhanglin
 * @Date: 2019/6/21
 * @Time: 4:16 PM
 *
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 分析：因为n级台阶，第一步有n种跳法：跳1级、跳2级、到跳n级
 *
 * 跳1级，剩下n-1级，则剩下跳法是f(n-1)
 * 跳2级，剩下n-2级，则剩下跳法是f(n-2)
 *
 * 所以f(n) = f(n-1) + f(n-2) + ... + f(1)
 * 因为f(n-1) = f(n-2) + f(n-3 )+ ... + f(1)
 *
 * 所以f(n) = 2 * f(n-1)。
 *
 * 根据f(1) = 1，f(n) = 2 * f(n-1)，可以得出f(n) = 2^(n-1)。
 *
 * 或者可以这么分析：每个台阶都有跳与不跳两种情况（除了最后一个台阶），最后一个台阶必须跳。所以共用2^(n-1)种情况。
 */
public class 变态青蛙 {
    public static void main(String[] args) {
        Long begintime = System.nanoTime();
        int result = JumpFloorII(10);
        Long endtime = System.nanoTime();
        System.out.println("result=" + result + "；用时：" + (endtime - begintime) + "ns");
    }

    public static int JumpFloorII(int target) {
        //第n次走的台阶个数是第n-1次走的台阶个数的2倍
        //所以状态转移方程为 dp[i] = 2*dp[i-1];
        int[] dp = new int[target + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= target; ++i) {
            dp[i] = 2 * dp[i - 1];
        }
        return dp[target];
    }

}
