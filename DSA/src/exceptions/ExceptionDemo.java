package exceptions;

public class ExceptionDemo {
	
	public static int fact(int i) throws NegativeNumberException {
		if(i<0) {
			throw new NegativeNumberException();
		}
		int ans = 1;
		for(int j=2; j<i; j++) {
			ans = ans * j;
		}
		return ans;
	}
	
	public static int divide(int a, int b) throws DivideByZero {
		if(b==0) {
			throw new DivideByZero();
		}
		
		return a/b;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			divide(1, 4);
			fact(-4);
			System.out.println("inside the catch block");
		}catch(DivideByZero d) {
			
			d.printStackTrace();
			System.out.println("inside the catch block");
			
		}catch(NegativeNumberException e) {
			e.printStackTrace();
			System.out.println("inside the negative block");
		}
		
	}

}
