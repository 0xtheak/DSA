package recurssion;

public class MinimumInArray {
	
	public static void minimumInArray(int[] arr, int index, int answer) {
		if(index==arr.length) {
			System.out.println(answer);
			return;
		}
		if(answer>arr[index]) {
			answer = arr[index];
		}
		minimumInArray(arr, index+1, answer);
		
	}

	public static void main(String[] args) {
		int[] arr = {10, 30, 2, 5, 9, 11, -1};
		minimumInArray(arr, 0, Integer.MAX_VALUE);
		
	}

}
