package suanfa.leetcode;

public class a80RemoveDuplicatesfromSortedArrayII {
    /**
     * @param nums
     * @return
     * 给出一个有序数组，将已经重复两次以上的字符剔除，返回剩余数组长度。例如 1，1，1，2，2，3，1，1，1。变化为1，1，2，2，3，1，1。返回7，同时原数组的前7位变为正确的数组。
     *
     */
//    Remove Duplicates from Sorted Array II
    public static int removeDuplicates(int[] nums) {
        if(nums.length<2){
            return nums.length;
        }
        int temp=nums[0];
        int insert=1;
        boolean gate=false;
        for(int i=1;i<nums.length;i++){
            if(nums[i]==temp){
                if(gate){
                    continue;
                }else{
                    gate=true;
                    nums[insert++]=temp;
                }
            }else{
                gate=false;
                nums[insert++]=nums[i];
                temp=nums[i];
            }
        }
        //只是为了区别后边的数不是连续与前面的
//        if(insert<nums.length){
//            nums[insert]=nums[insert-1]+1;
//        }
        return insert;
    }

    public static void main(String[] args) {
        int[] arr = {1,1,1,2,2,3};

    }
}
