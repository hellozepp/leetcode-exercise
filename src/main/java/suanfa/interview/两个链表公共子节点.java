package suanfa.interview;

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
        ListNode result = FindFirstCommonNode(a, d);
        Long endtime = System.nanoTime();

        if (result != null) {
            System.out.println("两个链表的第一个公共节点为：" + result.val + ",运行时间：" + (endtime - begintime) + "ns");
        } else {
            System.out.println("两个链表不相交");
        }

    }

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int count1 = 0;
        int count2 = 0;
        ListNode commonNode = null;
        ListNode pNode1 = pHead1;
        ListNode pNode2 = pHead2;
        //得到链表1的长度
        while (pNode1 != null) {
            count1++;
            pNode1 = pNode1.next;
        }
        //得到链表2的长度
        System.out.println("List1的长度为：" + count1);
        while (pNode2 != null) {
            count2++;
            pNode2 = pNode2.next;
        }
        System.out.println("List2的长度为：" + count2);
        //令pNode1和pNode2重新指向头结点
        pNode1 = pHead1;
        pNode2 = pHead2;
        int sub = count1 - count2;
        System.out.println("两个List相差" + sub + "个节点");
        //先在长链表上走几步，再同时在两个链表上遍历
        if (sub > 0) {
            for (int i = 0; i < sub; i++) {
                pNode1 = pNode1.next;
            }
        } else {
            for (int i = 0; i < Math.abs(sub); i++) {
                pNode2 = pNode2.next;
            }
        }
        System.out.println("List1从" + pNode1.val + "开始比较，List2从" + pNode2.val + "开始比较");
        //得到第一个公共节点
        while (pNode1 != null && pNode2 != null) {
            if (pNode1 != pNode2) {
                pNode1 = pNode1.next;
                pNode2 = pNode2.next;
            } else {
                commonNode = pNode1;
                return commonNode;
            }
        }
        return commonNode;
    }

}
