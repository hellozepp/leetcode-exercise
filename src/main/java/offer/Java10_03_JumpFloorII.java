/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题10（三）：变态跳台阶
 * // 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶...它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
package offer;

public class Java10_03_JumpFloorII {
	//思路：因为n级台阶，第一步有n种跳法：跳1级、跳2级、到跳n级，
	//跳1级，剩下n-1级，则剩下跳法是f(n-1)，
	//跳2级，剩下n-2级，则剩下跳法是f(n-2)，
	//所以f(n)=f(n-1)+f(n-2)+…+f(1)，
	//因为f(n-1)=f(n-2)+f(n-3)+…+f(1)， 
	//所以f(n)=2*f(n-1)，
	//所以f(n)=2的(n-1)次幂。
    public int JumpFloorII(int target) {
        if(target <= 0)
            return 0;
        return 1 << (target - 1);
    }
//    方法二：
//    public int JumpFloorII(int target) {
//        if(target == 0) {
//            return 0;
//        }
//         
//        int[] dp = new int[target + 1];
//        dp[0] = 1;
//        dp[1] = 1;
//         
//        for(int i = 2;i <= target;i++) {
//            dp[i] = 0;
//            for(int j = 0;j < i;j++) {
//                dp[i] += dp[j];
//            }
//        }
//         
//        return dp[target];
//    }
}
