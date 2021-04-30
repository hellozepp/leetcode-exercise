package suanfa.leetcode;

public class a80RemoveDuplicatesfromSortedArrayII {
    /**
     * @param nums
     * @return
     * 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度，
     * 你不需要考虑数组中超出新长度后面的元素。不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
     *
     * 输入： [1,1,1,2,2,3],
     * 输出：5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。
     * 输入 ： [0,0,1,1,1,1,2,3,3],
     * 输出：7, 并且原数组的前五个元素被修改为 0, 0, 1, 1, 2, 3, 3 。
     */
//    Remove Duplicates from Sorted Array II
    public static int removeDuplicates(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        int temp = nums[0];
        int insert = 1;
        boolean gate = false;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == temp) {
                if (!gate) {
                    gate = true;
                    nums[insert++] = temp;
                }
            } else {
                gate = false;
                nums[insert++] = nums[i];
                temp = nums[i];
            }
        }
        //只是为了区别后边的数不是连续与前面的
//        if(insert<nums.length){
//            nums[insert]=nums[insert-1]+1;
//        }
        return insert;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 2, 2, 3};

    }
}
