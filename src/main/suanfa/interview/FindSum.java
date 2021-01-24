package suanfa.interview;

import org.junit.Test;

/**
 * @Author: zhanglin
 * @Date: 2019/7/2
 * @Time: 11:33 PM
 */
public class FindSum {
    //给出一个排序好的数组和一个数，求数组中连续元素的和等于所给数的子数组

    @Test
    public void test() {
        int[] num = {1, 2, 2, 3, 4, 5, 6, 7, 7, 7, 8, 9};
        int target = 7;
        findSum(num, target);
    }

    public void findSum(int[] num, int target) {
        int l, r, sum;
        for (l = r = sum = 0; l < num.length; l++) {
            if (l != 0) sum -= num[l - 1];
            while (r < num.length && sum < target) {
                sum += num[r++];
            }

            if (sum == target) {
                for (int j = l; j < r; j++) {
                    System.out.print(num[j] + " ");
                }
                System.out.println();
            }
        }
    }

}
