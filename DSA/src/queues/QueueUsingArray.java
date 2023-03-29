package queues;

public class QueueUsingArray {
	private int data[];
	private int front;
	private int rear;
	private int size;
	
	public QueueUsingArray() {
		data = new int[5];
		front=-1;
		rear=-1;
	}
	public QueueUsingArray(int capacity) {
		data = new int[capacity];
		front=-1;
		rear=-1;
	}
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public void enqueue(int elem) throws QueueFullException {
		if(size==data.length) {
			throw new QueueFullException();
		}
		if(front==-1 && rear==-1) {
			front++;
		}
		rear= (rear+1) % data.length;
		data[rear] = elem;
		size++;
		
		
	}
	public int front() throws QueueEmptyException {
		if(front==-1) {
			throw new QueueEmptyException();
		}
		return data[front];
		
	}
	public int rear() throws QueueFullException {
		if(rear==-1) {
			throw new QueueFullException();
		}
		return data[rear];
	}
	public int dequeue() throws QueueEmptyException {
		if(size==0) {
			throw new QueueEmptyException();
		}
		int temp = data[front];
		size--;
		front= (front+1) % data.length;
		if(size==0) {
			front =-1;
			rear=-1;
		}
		return temp;
	}
	
	
}