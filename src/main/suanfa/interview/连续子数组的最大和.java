package suanfa.interview;

/**
 * @Author: zhanglin
 * @Date: 2019/6/20
 * @Time: 11:01 PM
 *
 * 我们需要求出max[f(i)]，其中0 <= i <= n。我们可以用如下递归公式求f(i)：
 *
 * f(i) = pData[i]                        i = 0或者f(i-1) <= 0
 *
 * f(i) = f(i-1) + pData[i]           i 不等于 0并且f(i-1) > 0
 */
public class 连续子数组的最大和 {
    public static void main(String[] args) {
        int[] array = {1, -2, 3, 10, -4, 7, 2, -5};
        Long begintime = System.nanoTime();
        int result = FindGreatestSumOfSubArray(array);
        Long endtime = System.nanoTime();
        System.out.println("连续子数组的最大和为：" + result + ",运行时间：" + (endtime - begintime) + "ns");

    }

    public static int FindGreatestSumOfSubArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] res = new int[arr.length];
        res[0] = arr[0];
        int sum = arr[0];
        System.out.println("第1步：累加子数组和：" + res[0] + "，最大子数组和：" + sum);
        for (int i = 1; i < arr.length; i++) {
            //下面是动态规划的状态转移方程
            if (res[i - 1] > 0) {
                res[i] = res[i - 1] + arr[i];
            } else {
                res[i] = arr[i];
            }
            //根据currentsum的值更新greatsetsum的值
            if (res[i] > sum) {
                sum = res[i];
            }
            System.out.println("第" + (i + 1) + "步：累加子数组和：" + res[i] + "，最大子数组和：" + sum);
        }
        return sum;
    }

}
