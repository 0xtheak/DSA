package oops;

public class Polynomial {
	private DynamicArray coefficients;
	
	public Polynomial() {
		coefficients = new DynamicArray();
	}
	
	public void setCoefficents(int deg, int coeff) {
		if(coefficients.getSize()<deg) {
			while(coefficients.getSize()<deg) {
				coefficients.add(0);
			}
			coefficients.add(coeff);
		}else {
			coefficients.set(deg, coeff);
		}
		
	}
	
	public void print() {
		for(int i=0; i<coefficients.getSize(); i++) {
			if(coefficients.get(i)!=0) {
				System.out.print(coefficients.get(i) + "X^" + i + " + " );
			}
			
		}
	}
	
	public int getCoefficient(int i) {
		if(i<coefficients.getSize()) {
			return coefficients.get(i);
		}
		
		return -1;
	}
}
