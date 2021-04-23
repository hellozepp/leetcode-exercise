package suanfa.剑指offer;

/**
 * @Author: zhanglin
 * @Date: 2019/7/4
 * @Time: 1:33 PM
 * 数组中出现次数超过一半的数字
 *
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalfNum_Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        if (array.length <= 0) {
            return 0;
        }
        int temp = array[0], count = 1;
        for (int i = 1; i < array.length; i++) {
            if (temp == array[i]) {
                count++;
            } else if (count == 0) {
                temp = array[i];
                count++;
            } else {
                count--;
            }
        }
        int realcount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == temp) {
                realcount++;
            }
        }
        if (realcount > array.length / 2) {
            return temp;
        }
        return 0;

    }
}
