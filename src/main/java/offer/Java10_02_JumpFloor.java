/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题10（二）：青蛙跳台阶问题
 * // 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
package offer;

public class Java10_02_JumpFloor {
	//思路：斐波拉契数序列，初始条件n=1:只能一种方法。n = 2:两种方法。
	//对于第n个台阶来说，只能从n-1或者n-2的台阶跳上来，所以F(n) = F(n-1) + F(n-2)
    public int JumpFloor(int target) {
        long JumpOne = 1;
        long JumpTwo = 2;
        long JumpN = 0;
        int result[] = {0, 1, 2};
        if(target < 0) {
            return 0;
        }
        if(target < 3) {
            return result[target];
        }
        else {
            for (int i = 3; i <= target; i++) {
                JumpN = JumpTwo + JumpOne;
                JumpOne = JumpTwo;
                JumpTwo = JumpN;
            }
        }
        return (int)JumpN;
    }
}
