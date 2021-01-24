package suanfa.leetcode;

public class a167TwoSumII {
    //双指针法 (对撞指针)
    public int[] solution(int[] arr, int target) {

        int l = 0, r = arr.length - 1;
        while (l < r) {
            if (arr[l] + arr[r] == target) {
                return new int[]{l + 1, r + 1};
            } else if (arr[l] + arr[r] < target) {
                l++;
            } else {
                r--;
            }
        }
        return new int[]{};
    }

    /**
     * @param args 给定一个有序整型数组和一个整数target，在其中寻找两个元素，使其和为target。返回这两个数的索引。
     *             如numbers = [2, 7, 11, 15], target = 9
     *             返回数字2，7的索引1, 2 (索引从1开始计算)
     *             题目一定能找到，而且只有一对zhi值
     */
    public static void main(String[] args) {
        int[] solution = new a167TwoSumII().solution(new int[]{2, 7, 11, 15}, 9);
        for (int i : solution)
            System.out.print(i + " ");
    }
}
