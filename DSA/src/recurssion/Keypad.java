package recurssion;

import java.util.Scanner;

public class Keypad {
	public static String getOptions(int n) {
		switch(n) {
		case 1:
			return "";
		case 2:
			return "abc";
		case 3:
			return "def";
		case 4:
			return "ghi";
		case 5:
			return "jkl";
		case 6:
			return "mno";
		case 7:
			return "pqrs";
		case 8:
			return "tuv";
		case 9:
			return "wxyz";
		default:
			return "";
		}
	}
	public static String[] keypadCombination(int input) {
		if(input==0) {
			String[] output = new String[1];
			output[0] = " ";
			return output;
		}
		String[] smallOutput = keypadCombination(input/10);
		int lastDigit = input % 10;
		String lastDigitOptions = getOptions(lastDigit);
		
		String[] output = new String[smallOutput.length *lastDigitOptions.length()];
		int k=0;
		for(int i=0; i<smallOutput.length; i++) {
			for(int j=0; j<lastDigitOptions.length(); j++) {
				output[k++] = smallOutput[i] + lastDigitOptions.charAt(j);
			}
		}
		return output;
	}
	
	public static void keypadCombinationBetter(int input, String sofar) {
		if(input==0) {
			System.out.print(sofar + " ");
			return;
		}
		String lastDigitOptions = getOptions(input%10);
		for(int i=0; i<lastDigitOptions.length(); i++) {
			keypadCombinationBetter(input/10, lastDigitOptions.charAt(i) + sofar);
		}
		
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the input for the keypad combination");
		int input = s.nextInt();
//		String[] output = keypadCombination(input);
//		for(String i : output) {
//			System.out.print(i + " ");
//		}
		keypadCombinationBetter(input, "");
		

	}

}
