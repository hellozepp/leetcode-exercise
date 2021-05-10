package suanfa.interview;

import java.util.HashSet;
import java.util.Set;

import static suanfa.interview.环形入口节点.ListNode;

/**
 * @Author: zhanglin
 * @Date: 2019/6/20
 * @Time: 11:44 PM
 */
public class 两个链表公共子节点 {
    // 链表交叉点
    public static void main(String[] args) {
        //构造链表结构测试用
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        //第一个List
        a.next = b;
        b.next = c;
        c.next = f;
        f.next = g;
        //第二个List
        d.next = b;
        b.next = e;

        Long begintime = System.nanoTime();
        ListNode result = findFirstCommonNode(a, d);
        Long endtime = System.nanoTime();

        if (result != null) {
            System.out.println("两个链表的第一个公共节点为：" + result.val + ",运行时间：" + (endtime - begintime) + "ns");
        } else {
            System.out.println("两个链表不相交");
        }

    }

    /**
     * 时间 on 空间 on
     * @param pHead1
     * @param pHead2
     * @return
     */
    public static ListNode findFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        Set<ListNode> set = new HashSet<>();
        while (pHead1 != null) {
            set.add(pHead1);
            pHead1 = pHead1.next;
        }
        ListNode cur = pHead2;
        // 如果都没找到,cur 会被设置为 null
        while (cur != null && !set.contains(cur)) {
            cur = cur.next;
        }
        return cur;
    }

}
