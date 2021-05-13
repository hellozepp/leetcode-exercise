package suanfa.leetcode;

import java.util.Stack;

/**
 * Some examples:
 * 逆波兰表达式求值，栈实现，最近一个运算符和两个数值组合
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 * 输入：tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * 输出：22
 * 解释：
 * 该算式转化为常见的中缀算术表达式为：
 *   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * = ((10 * (6 / -132)) + 17) + 5
 * = ((10 * 0) + 17) + 5
 * = (0 + 17) + 5
 * = 17 + 5
 * = 22
 */
public class Solution150 {

    public int evalRPN(String[] tokens) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)) {
                stack.push(stack.pop() + stack.pop());
            } else if ("-".equals(token)) {
                stack.push(stack.pop() - stack.pop());
            } else if ("*".equals(token)) {
                stack.push(stack.pop() * stack.pop());
            } else if ("/".equals(token)) {
                stack.push(stack.pop() / stack.pop());
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        if (!stack.isEmpty()) {
            res = stack.pop();
        }
        return res;
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"1", "2", "+", "3", "*"};
        String[] tokens1 = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        int i = new Solution150().evalRPN(tokens);
        System.out.println(i);
        System.out.println(new Solution150().evalRPN(tokens1));
        System.out.println("------------");
        System.out.println("/1".split("/", 1).length);
        System.out.println(4 >> 1);
        System.out.println(4 << 1);
    }
}