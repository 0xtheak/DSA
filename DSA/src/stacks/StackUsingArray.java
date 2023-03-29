package stacks;

public class StackUsingArray {
	private int[] data;
	private int topIndex;
	private boolean capacityFlag=false;
	
	public StackUsingArray(int capacity) {
		this.data = new int[capacity];
		this.topIndex=-1;
		this.capacityFlag=true;
	}
	public StackUsingArray() {
		this.data = new int[5];
		this.topIndex=-1;
	}
	
	private void increaseSize() {
		int[] temp = data;
		data = new int[2*temp.length];
		for(int i=0; i<temp.length; i++) {
			data[i] = temp[i];
		}
	}
	
	public void push(int ele) throws StackFullException {
		if(topIndex==data.length-1) {
			if(capacityFlag) {
				throw new StackFullException();
			}else {
				increaseSize();
			}
			
		}
		data[++topIndex] = ele;
		
	}
	public int pop() throws StackEmptyException {
		if(topIndex==-1) {
			throw new StackEmptyException();
		}
		return data[topIndex--];
		
	}
	public int top() {
		return data[topIndex];
		
	}
	public int size() {
		return topIndex+1;
		
	}
	public boolean isEmpty() {
		return topIndex==-1;
		
	}

}
