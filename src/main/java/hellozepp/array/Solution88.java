package hellozepp.array;


/**
 * 归并 2个 有序数组 放入num1
 * <p>
 * 难度2星
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 */
public class Solution88 {

    public void merge(int[] num1, int m, int[] num2, int n) {

        int length = m + n;


        while (n>0){

            if(m==0|| num1[m-1]<num2[n-1])
                num1[--length]= num2[--n];
            else  num1[--length]=num1[--m];

        }



    }
}