package leetcodeAll.leetcode2;

import java.util.Stack;

/**
 * 150. Evaluate Reverse Polish Notation
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String str : tokens) {
            if (str.equals("+"))
                stack.push(stack.pop() + stack.pop());
            else if (str.equals("-")) {
                int tmp = stack.pop();
                stack.push(stack.pop() - tmp);
            } else if (str.equals("*"))
                stack.push(stack.pop() * stack.pop());
            else if (str.equals("/")) {
                int tmp = stack.pop();
                stack.push(stack.pop() / tmp);
            } else
                stack.push(Integer.valueOf(str));
        }
        return stack.pop();
    }

    public int evalRPN2(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int tmp;
        for (String str : tokens) {
            switch (str) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    tmp = stack.pop();
                    stack.push(stack.pop() - tmp);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    tmp = stack.pop();
                    stack.push(stack.pop() / tmp);
                    break;
                default:
                    stack.push(Integer.valueOf(str));
            }
        }
        return stack.pop();
    }

    public int evalRPN3(String[] tokens) {
        index = tokens.length;
        return help(tokens);
    }

    private int index;

    private int help(String[] tokens) {
        char[] cs = tokens[--index].toCharArray();
        int num1, num2;
        if (cs.length > 1)
            return Integer.valueOf(tokens[index]);
        switch (cs[0]) {
            case '+':
                num1 = help(tokens);
                num2 = help(tokens);
                return num2 + num1;
            case '-':
                num1 = help(tokens);
                num2 = help(tokens);
                return num2 - num1;
            case '*':
                num1 = help(tokens);
                num2 = help(tokens);
                return num2 * num1;
            case '/':
                num1 = help(tokens);
                num2 = help(tokens);
                return num2 / num1;
            default:
                return Integer.valueOf(tokens[index]);
        }
    }
}
