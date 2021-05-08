package suanfa.interview;

/**
 * @Author: zhanglin
 * @Date: 2019/6/19
 * @Time: 11:32 PM
 * 判断链表是否有环
 */
public class 环形入口节点 {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    public static void main(String[] args) {
        //构造链表结构测试用
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        ListNode e = new ListNode(5);
        ListNode f = new ListNode(6);
        ListNode g = new ListNode(7);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
//        f.next = c;

        Long begintime = System.nanoTime();
        ListNode result = EntryNodeOfLoop(a);
        Long endtime = System.nanoTime();
        if (result != null) {
            System.out.println("链表的入环节点为：" + result.val + ",运行时间：" + (endtime - begintime) + "ns");
        } else {
            System.out.println("该链表中没有环");
        }

    }

    //两个指针相遇的节点
    public static ListNode MeetingNode(ListNode pHead) {
        ListNode p = pHead;
        ListNode q = pHead;
        ListNode meet = null;
        while (p != null && q != null) {
            p = p.next;
            if (q.next == null) {
                //快指针结束
                return meet;
            }
            q = q.next.next; //防止空指针 条件是链表值不重复,重复的话应该比较节点对象是否相等
            if (p != null && q != null && p.val == q.val) {
                meet = p;
                return meet;
            }
        }
        return meet;

    }

    //环的入口节点
    public static ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode meetingNode = MeetingNode(pHead);
        ListNode loopnode = null;
        if (meetingNode == null) {
            return loopnode;
        }
        System.out.println("在环中相遇的节点为：" + meetingNode.val);
        ListNode pNode1 = pHead;
        ListNode pNode2 = pHead;
        //得到环中节点的数目
        int nodeInLoop = 1;
        ListNode temp = meetingNode;
        while (temp.next != meetingNode) {
            temp = temp.next;
            nodeInLoop++;
        }
        System.out.println("环中节点的数目为：" + nodeInLoop + "个");
        //先移动pNode1,次数为环中节点的数目(range),指向环数量的下一个节点,即入口
        pNode1 = pHead;
        for (int i = 0; i < nodeInLoop; i++) {
            pNode1 = pNode1.next;
        }
        //再移动pNode1和pNode2
        while (pNode1 != pNode2) {
            pNode1 = pNode1.next;
            pNode2 = pNode2.next;
        }
        return pNode1;
    }

}
