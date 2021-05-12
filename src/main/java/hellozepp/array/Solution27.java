package hellozepp.array;


/**
 * 给定一个数组和一个值，在这个数组中原地移除指定值和返回移除后新的数组长度。
 *
 * 不要为其他数组分配额外空间，你必须使用 O(1) 的额外内存原地修改这个输入数组。
 *
 * 元素的顺序可以改变。<b>超过返回的新的数组长度以外的数据无论是什么都没关系。</b>
 *
 *
 * 难度 1星
 *
 */
public class Solution27 {


    public int removeElement(int[] nums, int val) {

        int c = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != val) {
                nums[c++] = nums[i];
            }
        }
        return c;// 注意这里长度应该加一,而上面自增已经加过
    }

    public static void main(String[] args) {
        int[] ints = {1, 2, 2, 3};
        System.out.println(new Solution27().removeElement(ints, 2));
        for (int anInt : ints) {
            System.out.print(anInt + ",");
        }
    }
}