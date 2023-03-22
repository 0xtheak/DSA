package oops;

public class DynamicArray {
	private int data[];
	private int size;;
	
	public DynamicArray() {
		data = new int[5];
		size=0;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public int getSize() {
		return size;
	}
	
	public void inccreaseSize() {
		int len = data.length;
		int temp[] = data;
		data = new int[len*2];
		for(int i=0; i<len; i++) {
			data[i] = temp[i];
		}
	}
	
	public void add(int d) {
		if(size==data.length) {
			inccreaseSize();
		}
		data[size++] = d;
	}
	
	public int get(int i) {
		if(i<size) {
			return data[i];
		}
		
		return -1;
	}
	
	public void set(int k, int v) {
		if(k<size) {
			data[k] = v;
		}
		return;
	}
	
	public int removeLast() {
		if(size==0) {
			return -1;
		}
		return data[(size--)-1];
	}
}
