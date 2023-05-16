package recurssion;

public class MinStepToOne {
	public static int minStepToOne(int n) {
		if(n==1 || n==0) {
			return 0;
		}
		int a = Integer.MAX_VALUE, b=Integer.MAX_VALUE, c=Integer.MAX_VALUE;
		a = minStepToOne(n-1) + 1;
		if(n%2==0) {
			b = minStepToOne(n/2) +1;
		}
		if(n%3==0) {
			c= minStepToOne(n/3) +1;
		}
		
		return Math.min(a, Math.min(b, c));
	}

	public static void main(String[] args) {
		System.out.println(minStepToOne(7));

	}

}
