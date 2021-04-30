/**
 * //==================================================================
 * // 《剑指Offer——名企面试官精讲典型编程题》代码
 * //
 * //==================================================================
 * // 面试题30：包含min函数的栈
 * // 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 */
package offer;
import java.util.Stack;

public class Java30_MinInStack {
	Stack<Integer> m_data = new Stack<Integer>();
	Stack<Integer> m_min = new Stack<Integer>();
    
	public void push(int node) {
		if (m_min.isEmpty()) {
		    m_min.push(node);
		}
		else {
		    int top = m_min.peek();
		    if (node < top) {
		        m_min.push(node);
		    }
		    else {
		        m_min.push(top);
		    }
		}
		m_data.push(node);
	}
    
	public void pop() {
		if (!m_data.isEmpty()) {
		    m_data.pop();
		    m_min.pop();
		}
	}
    
	public int top() {
		return m_data.peek();
	}
    
	public int min() {
		if (m_min.isEmpty()) {
		    return 0;
		}
		return m_min.peek();
	}
}