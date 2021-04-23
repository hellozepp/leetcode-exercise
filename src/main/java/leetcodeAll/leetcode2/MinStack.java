package leetcodeAll.leetcode2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 * 155. Min Stack
 *
 * 设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) -- 将元素 x 推入栈中。
 * pop() -- 删除栈顶的元素。
 * top() -- 获取栈顶元素。
 * getMin() -- 检索栈中的最小元素。
 *
 */
public class MinStack {

    private static Stack<Integer> stack1 = new Stack<>();
    private static Stack<Integer> stack2 = new Stack<>();

    public MinStack() {
        stack1.clear();
        stack2.clear();
    }

    public void push(int x) {
        stack1.push(x);
        if (stack2.isEmpty())
            stack2.push(x);
        else
            stack2.push(x <= stack2.peek() ? x : stack2.peek());
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}
//这个方案好都是o1
class MinStack2 {
    private Stack<Node> stack = new Stack<>();

    public class Node {
        int val;
        int min;

        public Node(int val, int min) {
            this.val = val;
            this.min = min;
        }
    }

    public MinStack2() {
        stack.clear();
    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(new Node(x, x));
        } else {
            stack.push(new Node(x, x <= stack.peek().min ? x : stack.peek().min));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().val;
    }

    public int getMin() {
        return stack.peek().min;
    }
}

/**
 * 思路：用一个int型成员变量min记录当前栈中的最小值
 * push(x)的时间复杂度是O(1)。
 *
 * pop()操作由于要更新最小值min，其时间复杂度是O(n)，其中n为栈中的元素个数。
 *
 * top()的时间复杂度是O(1)。
 *
 * getMin()的时间复杂度是O(1)。
 */
class MinStack3 {
    protected LinkedList<Integer> stack;
    private int min;

    public MinStack3() {
        stack = new LinkedList<>();
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        stack.push(x);
        min = Math.min(min, x);
    }

    public void pop() {
        int num = stack.pop();
        if (stack.size() > 0) {
            Iterator<Integer> iterator = stack.iterator();
            min = iterator.next();
            while (iterator.hasNext()) {
                int next = iterator.next();
                if (min > next) {
                    min = next;
                }
            }
        } else {
            min = Integer.MAX_VALUE;
        }
    }

    public Integer top() {
        if (stack == null) {
            return null;
        }
        return stack.peek();
    }

    public Integer getMin() {
        if (stack == null) {
            return null;
        }
        return min;
    }
}