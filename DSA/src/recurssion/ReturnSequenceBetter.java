package recurssion;

import java.util.Scanner;

public class ReturnSequenceBetter {
	
	public static void printSubsequences(String input, String stringSoFar) {
		if(input.length() == 0) {
			System.out.println(stringSoFar);
			return;
		}
		String smallInput = input.substring(1);
		printSubsequences(smallInput, stringSoFar);
		printSubsequences(smallInput, stringSoFar + input.charAt(0));
		
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter some string");
		String input = s.next();
		printSubsequences(input, "");
		

	}

}
