package leetcodeAll.leetcode2;

import java.util.HashMap;
import java.util.Map;

/**
 * 146. LRU Cache
 */
public class LRUCache {
    public static class Node {
        public Node pre;
        public Node next;
        private int key;
        private int value;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head; //链表头，达到最大容量后移除头结点
    private Node tail;  //链表尾，最近使用的结点放在尾部

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (!map.containsKey(key))
            return -1;
        Node cur = map.get(key);
        update(cur);
        return tail.value;
    }

    public void put(int key, int value) {
        Node cur;
        if (map.containsKey(key)) {     //已有此key值，则更新value与链表
            cur = map.get(key);
            cur.value = value;
            update(cur);
            return;
        }
        cur = new Node(key, value);
        map.put(key, cur);
        if (head == null) {     //头结点为null表示第一次存入
            head = cur;
            tail = cur;
            return;
        }
        cur.pre = tail;
        tail.next = cur;
        tail = cur;
        if (map.size() > capacity) {  //如果容量超了，则变换头结点并移除旧的头结点
            map.remove(head.key);
            head = head.next;
            head.pre = null;
        }
    }

    private void update(Node cur) {     //更新链表，将结点cur放到尾部
        if (cur == tail)
            return;
        if (cur == head) {
            Node newHead = head.next;
            head.next = null;
            head.pre = tail;
            tail.next = head;
            tail = head;
            head = newHead;
        } else {
            cur.pre.next = cur.next;
            cur.next.pre = cur.pre;
            cur.pre = tail;
            cur.next = null;
            tail.next = cur;
            tail = cur;
        }
    }
}
