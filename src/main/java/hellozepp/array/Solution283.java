package hellozepp.array;


/**
 * 移动数组的0 到最后
 * <p/>
 * 保持其他数的顺序
 * <p/>
 * 1.最小移动次数
 * 2.不能copy数组
 *
 * 难度1星
 *
 */
public class Solution283 {


    public void moveZeroes(int[] nums) {

        if (nums == null || nums.length == 0) return;

        int i = 0;
        for (int n : nums) {
            if (n != 0) {
                nums[i++] = n;
            }
        }

//        Arrays.fill(nums,i,nums.length,0);

        while (i < nums.length) {
            nums[i++] = 0;
        }

    }

    // 默写
    public void moveZeroes1(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (index == 0) {
                    index++;
                    continue;
                }
                swap(nums, index++, i);
            }
        }
    }

    private void swap(int[] nums, int index, int i) {
        int swap = nums[i];
        nums[i] = nums[index];
        nums[index] = swap;
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};

        (new Solution283()).moveZeroes(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println("------------");
        (new Solution283()).moveZeroes1(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println("------------");

    }
}