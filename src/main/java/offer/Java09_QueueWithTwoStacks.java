/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题9：用两个栈实现队列
 * // 题目：用两个栈实现一个队列。队列的声明如下，请实现它的两个函数appendTail
 * // 和deleteHead，分别完成在队列尾部插入结点和在队列头部删除结点的功能。
 */
package offer;
import java.util.Stack;

public class Java09_QueueWithTwoStacks {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    //实现appendTail函数
    public void push(int node) {
        stack1.push(node);
    }
    
    //实现deleteHead函数
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
    
    //测试用例
    public static void main(String[] args) {
    	Java09_QueueWithTwoStacks testQueue = new Java09_QueueWithTwoStacks();
    	testQueue.push(1);
    	testQueue.push(2);
    	testQueue.push(3);
    	System.out.println(testQueue.pop());
	}
}