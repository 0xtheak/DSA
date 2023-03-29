package stacks;

public class StackUse {

	public static void main(String[] args)  {

		try{
			StackUsingLL<Integer> st = new StackUsingLL<>();
			
			for(int i=0; i<5; i++) {
				st.push(i);
			}
			while(!st.isEmpty()) {
				System.out.println("top ele " + st.pop());
				System.out.println("size of stack  "+ st.size());
				
				
			}
			
		}catch(StackEmptyException se) {
			System.out.println("catch block has been executed");
		}
		

	}

}
