[包含 min 函数的栈](https://www.nowcoder.com/practice/4c776177d2c04c2494f2555c9fcc1e49?tpId=13&tqId=11173&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking&from=cyc_github) 

## 方法一：双栈，分别存放数据和 min

```java

Stack<Integer> s1 = new Stack<>();
Stack<Integer> s2 = new Stack<>();

public void push(int node) {
    if (s2.isEmpty() || node <= s2.peek()) {  //注意，避免重复最小值被弹出
        s2.push(node);
    }
    s1.push(node);
}

public void pop() {
    if (s1.peek().equals((s2.peek()))) {  //注意，包装类需要使用 equals()
        s2.pop();
    }
    s1.pop();
}

public int top() {
    return s1.peek();
}

public int min() {
    return s2.peek();
}

```

## 方法二：单栈+ min，push() 中当 node<=min，先存第二小的元素，再存最小的元素

```java

Stack<Integer> s = new Stack<>();
int min = Integer.MAX_VALUE;

public void push(int node) {
    if (node <= min) {
        s.push(min);  //注意
        min = node;
    }
    s.push(node);
}

public void pop() {
    if (s.pop() == min) {
        min = s.pop();
    }
}

public int top() {
    return s.peek();
}

public int min() {
    return min;
}

```

## 方法三：构造 Node 类，包含 val&min&next，push() 中 next 体现栈的顺序关系

```java

class Node {
    int val;
    int min;
    Node next;

    private Node(int val, int min) {
        this(val, min, null);
    }

    private Node(int val, int min, Node next) {
        this.val = val;
        this.min = min;
        this.next = next;
    }
}

Node head;

public void push(int node) {
    if (head == null) {
        head = new Node(node, node);
    } else {
        head = new Node(node, Math.min(node, head.min), head);  //注意
    }
}

public void pop() {
    head = head.next;
}

public int top() {
    return head.val;
}

public int min() {
    return head.min;
}

```
