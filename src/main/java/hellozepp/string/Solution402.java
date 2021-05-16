package hellozepp.string;

/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。
 *
 *     num 的长度小于 10002 且 ≥ k。
 *     num 不会包含任何前导零。
 *
 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 *
 * 解题思路：
 *
 * 使用模拟栈。
 *
 * 后面的小于前面的，则删除前面的
 * 如果存在0怎么处理
 * 如果遍历完k>0怎么办
 */
class Solution402 {
    public String removeKdigits(String num, int k) {
        if (num.length() == 0 || num.length() <= k) {
            return "0";
        }
        char strStack[] = new char[num.length()];
        int newLength = num.length() - k;
        int top = 0;
        for (int i = 0; i < num.length(); i++) {
            char c = num.charAt(i);
            while (top > 0 && strStack[top - 1] > c && k > 0) {
                top--;
                k--;
            }
            strStack[top++] = c;
        }

        int index = 0;
        while (index < newLength && strStack[index] == '0') {
            index++;
        }
        return index == newLength ? "0" : new String(strStack, index, newLength - index);
    }
}