package oops;

public class Fraction {
	private int numerator ;
	private int denominator;
	public Fraction(int numerator, int denominator) throws DivideByZeroException {
//		this.numerator = numerator;
		setNumerator(numerator);
//		this.denominator = denominator;
		setDenominator(denominator);
		simplify();
	}
	
	public void simplify() {
		int gcd = 1;
		int smaller = Math.min(numerator, denominator);
		for(int i=2; i<=smaller; i++) {
			if(numerator%i == 0 && denominator%i == 0  ) {
				gcd = i;
			}
			
		}
		numerator = numerator/gcd;
		denominator = denominator /gcd;
		
	}
	public void increament() {
		numerator = numerator + denominator;
		simplify();
	}
	
	public void setNumerator(int num) {
		this.numerator = num;
	}
	public int getNumerator() {
		return numerator;
		
	}
	
	public void setDenominator(int deno) throws DivideByZeroException {
		if(deno==0) {
			throw new DivideByZeroException();
//			return;
		}
		this.numerator = deno;
	}
	public int getDenominator() {
		return this.denominator;
		
	}
	
	public void print() {
		System.out.println(numerator + "/" + denominator);
	}
	
	public void add(Fraction f2) {
		this.numerator = this.numerator * f2.denominator + f2.numerator * this.denominator;
		this.denominator =  this.denominator * f2.denominator;
		simplify();
	}
	
	public static Fraction add(Fraction f1, Fraction f2) throws DivideByZeroException {
		Fraction f3  = new Fraction(f1.numerator * f2.denominator + f2.numerator * f1.denominator, f1.denominator * f2.denominator);
		f3.simplify();
		return f3;
	}

}
