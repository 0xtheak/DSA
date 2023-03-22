package oops;

public class ComplexNumber {
	private int real;
	private int imaginary;
	
	public ComplexNumber(int real, int imaginary) {
		this.real  = real;
		this.imaginary = imaginary;
	}
	public void setReal(int real) {
		this.real = real;
	}
	public int getReal() {
		return this.real;
	}
	
	public void setImaginary(int imaginary) {
		this.imaginary = imaginary;
	}
	public int getImaginary() {
		return this.imaginary;
	}
	
	public void print() {
		System.out.println(this.real + "+" + this.imaginary + "i");
	}
	
	public void add(ComplexNumber c2) {
		this.real = this.real + c2.real;
		this.imaginary = this.imaginary  + c2.imaginary;
	}
	
	public void multiply(ComplexNumber c2) {
//		int r = (this.real * c2.real)  + (this.imaginary * c2.imaginary)*-1;
//		int img = (this.real * c2.imaginary) + (this.imaginary + c2.real);
//		this.real = r;
//		this.imaginary = img;
		int temp = (this.real * c2.real) - (this.imaginary * c2.imaginary);
        this.imaginary = (this.real * c2.imaginary) + (this.imaginary * c2.real);
        this.real = temp;
	}

}
