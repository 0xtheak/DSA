package oops;

public class DynamicArrayUse {

	public static void main(String[] args) {
		DynamicArray d = new DynamicArray();
		System.out.println(d.isEmpty());
		for(int i=1; i<100; i++) {
			d.add(100 + i);
		}
		d.set(2, 2);
		d.add(1);
		for(int i=0; i<100; i++) {
			System.out.print(d.get(i) + " ");
		}
		
		System.out.println(d.get(2));
		System.out.println(d.isEmpty());
		System.out.println(d.getSize());
		

	}

}
