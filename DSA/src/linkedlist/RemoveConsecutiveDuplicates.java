package linkedlist;

import java.util.*;

public class RemoveConsecutiveDuplicates {
	public static ArrayList<Integer> removeConsecutives(int arr[]){
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(arr[0]);
		for(int i=1; i<arr.length-1; i++) {
			if(arr[i]!=arr[i+1]) {
				result.add(arr[i+1]);
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = { 1,1,1,1,1,3,3,3,4,2,2,5,5,6};
		ArrayList<Integer> output = removeConsecutives(arr);
		for(int i : output) {
			System.out.println(i);
		}
	}

}
