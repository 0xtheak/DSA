package oops;

public class FractionUse {

	public static void main(String[] args) {
		int n=3252345;
		while(n>0) {
			int rem = n%10;
			n = n/10;
			System.out.println(rem);
		}
//		try {
//			Fraction f1 = new Fraction(6, 3);
//			f1.print();
//			
//			Fraction f2 = new Fraction(2, 0);
//			f2.print();
//			f1.add(f2);
//			f1.print();
//			Fraction f3 = Fraction.add(f1, f2);
//			f3.print();
//		}catch(DivideByZeroException e) {
//			System.out.println("Divide by zero exception");
//		}
		
		

	}

}
