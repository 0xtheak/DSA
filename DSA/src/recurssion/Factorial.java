package recurssion;



public class Factorial {

	public static int  factorial(int input) {
		if(input==0) {
			return 1;
		}
		return input * factorial(input-1);
	}
	public static void factorial2(int input, int answer) {
		if(input==0) {
			System.out.println(answer);
			return;
		}
		factorial2(input-1, answer*input);
		
	}
	
	public static int fibbonacci(int input) {
		if(input==0 || input == 1) {
			return 1;
		}
		return fibbonacci(input-1) + fibbonacci(input-2);
	}
	public static void main(String[] args) {
		int n = 5;
//		System.out.print(fibbonacci(4));
		factorial2(5, 1); 

	}

}
