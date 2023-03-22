package oops;

public class PolynomialUse {

	public static void main(String[] args) {
		Polynomial p1 = new Polynomial();
		p1.setCoefficents(1, 1);
		p1.setCoefficents(0, 2);
		p1.setCoefficents(5, 8);
		
		p1.print();
		Polynomial p2 = new Polynomial();
		p2.setCoefficents(2, 5);
		p2.setCoefficents(3, 10);
		p2.setCoefficents(4, 4);
		System.out.println();
		p2.print();
		System.out.println(p1.getCoefficient(0));

	}

}
