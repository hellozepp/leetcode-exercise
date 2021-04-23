package suanfa.leetcode;

import java.util.Stack;

/**
 * Some examples:
 * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 */
public class Solution150 {

    public int evalRPN(String[] tokens) {
        int res =0;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if ("+".equals(token)){
                stack.push(stack.pop()+stack.pop());
            }else if("-".equals(token)){
                stack.push(stack.pop()-stack.pop());
            }else if ("*".equals(token)){
                stack.push(stack.pop()*stack.pop());
            }else if ("/".equals(token)){
                stack.push(stack.pop()/stack.pop());
            }else {
                stack.push(Integer.parseInt(token));
            }
        }
        if (!stack.isEmpty()){
            for (Integer integer : stack) {
                res+=integer;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String[] tokens = new String[]{"1","2","+","3","*"};
        int i = new Solution150().evalRPN(tokens);
        System.out.println(i);
        System.out.println("/1".split("/",1).length);
        System.out.println(4>>1);
        System.out.println(4<<1);
    }
}