package suanfa.playWithAlgorithmInterview.linkedlist;

public class MyLinkedList implements Cloneable {
    public int val;
    public MyLinkedList next;
    public int size;

    public MyLinkedList getNext() {
        return next;
    }

    public void setNext(MyLinkedList next) {
        this.next = next;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public MyLinkedList(int i) {
        this.val = i;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        MyLinkedList myLinkedList = (MyLinkedList) super.clone();
        return myLinkedList;
    }

    public static MyLinkedList createLinkedList(int[] arr) {
        MyLinkedList head = new MyLinkedList(arr[0]);
        head.size++;
        MyLinkedList cur = head;
        for (int i = 1; i < arr.length; i++) {
            cur.setNext(new MyLinkedList(arr[i]));
            cur = cur.getNext();
            head.size++;
        }
        return head;
    }

    public static void printLinkedList(MyLinkedList list) {
        MyLinkedList cur = list;
        while (cur != null) {
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println("NULL");
    }

    public void add(int val) {
        MyLinkedList cur = this;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = new MyLinkedList(val);
        size++;
    }

    //使用克隆避免原链表被修改 指定pre 指定next,cur指向pre,pre移动到cur,cur移动到next
    public static MyLinkedList reverseLinkedList(MyLinkedList head) throws CloneNotSupportedException {
        MyLinkedList pre = null;
        MyLinkedList cur = (MyLinkedList) head.clone();
        while (cur != null) {
            MyLinkedList next = cur.getNext();
            cur.setNext(pre);
            pre = cur;
            if (next == null) {
                cur = null;
                break;
            }
            cur = (MyLinkedList) next.clone();

        }
        return pre;

    }

    //原链表上操作
    public static MyLinkedList reverseLinkedListOld(MyLinkedList root) {
        MyLinkedList pre = null;
        MyLinkedList cur = root;
        while (cur != null) {
            MyLinkedList next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public boolean remove(int val) {
        MyLinkedList dummyHead = new MyLinkedList(0);
        dummyHead.next = this;
        MyLinkedList cur = dummyHead;
        boolean flag = false;
        while (cur.next != null) {
            if (cur.next.val == val) {
                MyLinkedList del = cur.next;
                cur.next = del.next;
                del.next = null;
                flag = true;
                size--;
            } else {
                cur = cur.next;
            }
        }
        return flag;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        int[] arr = {1, 2, 3, 4, 5};
        MyLinkedList head = createLinkedList(arr);
        printLinkedList(head);
        MyLinkedList myLinkedList = reverseLinkedListOld(head);
        printLinkedList(myLinkedList);
        System.out.println(head.remove(1));
        System.out.println(head.size);
    }
}
