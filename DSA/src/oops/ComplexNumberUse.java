package oops;

public class ComplexNumberUse {

	public static void main(String[] args) {
		ComplexNumber c1 = new ComplexNumber(1,2);
		c1.print();
		ComplexNumber c2 = new ComplexNumber(4,5);
		c2.print();
		c1.multiply(c2);
		c1.print();
	}

}
