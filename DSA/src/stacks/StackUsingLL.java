package stacks;
import linkedList.Node;

public class StackUsingLL<T> {
	private Node<T> head;
	private int size;
	
	
	public StackUsingLL() {
		head = null;
		size=0;
	}
	
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	
	public T top() throws StackEmptyException {
		if(head==null) {
			throw new StackEmptyException();
		}
		return head.data;
		
	}
	
	public void push(T ele) {
		Node<T> child = new Node<>(ele);
		child.next = head;
		head = child;
		size++;
	}
	
	public T pop() throws StackEmptyException {
		if(head==null) {
			throw new StackEmptyException();
		}
		
		T output = head.data;
		head = head.next;
		size--;
		return output;
		
	}
	
	
}
