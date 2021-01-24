package suanfa.playWithAlgorithmsData.stack;
/**
 * ջ�������ʾ
 * @author Administrator
 *
 */
public class StackInList {
	Node top;
	void push(int d){
		Node node = new Node(d);
		node.next=top;
		top = node;
	}
	int pop(){
		if(top==null)
			return -1;
		int data = top.data;
		top=top.next;
		return data;
	}

}
class Node{
	Node next ;
	int data;
	public Node(int d){
		data = d;
	}
}
