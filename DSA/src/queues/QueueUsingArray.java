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
	
	private void doubleCapacity() {
		int[] temp = data;
		data = new int[2*temp.length];
		int index=0;
		for(int i=front; i<temp.length; i++) {
			data[index++] = temp[i];
		}
		for(int i=0; i<front-1; i++) {
			data[index++] = temp[i];
		}
		rear=temp.length-1;
		front=0;
	}
	
	public void enqueue(int elem) {
		if(size==data.length) {
			doubleCapacity();
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
	public int rear() throws QueueEmptyException {
		if(rear==-1) {
			throw new QueueEmptyException();
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
