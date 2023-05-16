package recurssion;

import java.util.*;

public class ReturnSequences {
	
	public static String[] subSequences(String s){
		if(s.length()==0) {
			String[] output = new String[1];
			output[0] =  "";
			return output;
		}
		String[] smallOutput = subSequences(s.substring(1));
		String[] output = new String[smallOutput.length *2];
		for(int i=0; i<smallOutput.length; i++ ) {
			output[i] = smallOutput[i];
		}
		for(int i=0; i<smallOutput.length; i++) {
			output[smallOutput.length+i] = s.charAt(0) +  smallOutput[i];
		}
		return output;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.next();
		String[] output = subSequences(input);
		for(String i: output) {
			System.out.print(i + " ");
		}

	}

}
