package leetcodeAll.leetcode;

/**
 * 45. Jump Game II
 * 
 * @author Watcher
 *
 */
public class JumpGameII {

	public static void main(String[] args) {
		JumpGameII so = new JumpGameII();
		int[] nums = { 3, 2, 1 };
		System.out.println(so.jump(nums));
	}

	public int jump(int[] nums) {
		if (nums.length < 2)
			return 0;
		int cur = 0, next = 0, cnt = 0;
		for (int i = 0; i < nums.length; i++) {
			if (i > next)
				return -1;
			if (i > cur) {
				cur = next;
				cnt++;
			}
			next = Math.max(next, nums[i] + i);
		}
		return cnt;
	}

	public int jump2(int[] nums) {
		if (nums == null || nums.length <= 1)
			return 0;
		int cnt = 0, cur = 0, next = 0;
		while (cur < nums.length) {
			if (cur == nums.length - 1)
				return cnt;
			if (cur + nums[cur] >= nums.length - 1)
				return cnt + 1;
			int max = -1;
			for (int i = 1; i <= nums[cur]; i++) {
				if (nums[i + cur] + i > max) {
					max = nums[i + cur] + i;
					next = i + cur;
				}
			}
			cur = next;
			cnt++;
		}
		return cnt;
	}
}
