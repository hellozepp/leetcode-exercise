package leetcodeAll.leetcode;

/**
 * 55. Jump Game
 * 
 * @author Watcher
 *
 */
public class JumpGame {
	public boolean canJump(int[] nums) {
		if (nums.length <= 1)
			return true;
		int cur = 0, next = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > next)
				return false;
			if (i > cur)
				cur = next;
			next = Math.max(next, i + nums[i]);
		}
		return true;
	}
}
