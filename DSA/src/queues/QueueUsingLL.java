package queues;

public class QueueUsingLL<T> {
	private Node<T> front;
	private Node<T> rear;
	private int size;
	
	public QueueUsingLL() {
		front=null;
		rear=null;
		size=0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public void enqueue(T ele) {
		Node<T> child = new Node<>(ele);
		if(rear==null) {
			front=child;
			rear=child;
		}else {
			rear.next=child;
			rear=child;
		}
		size++;
		
	}
	public T front() throws QueueEmptyException {
		if(size==0) {
			throw new QueueEmptyException();
		}
		return front.data;
		
	}
	
	public T dequeue() throws QueueEmptyException {
		if(size==0) {
			throw new QueueEmptyException();
		}
		T output = front.data;
		front = front.next;
		size--;
		return output;
	}
}
