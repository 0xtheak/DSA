package hashMap;

import java.util.*;

public class RemoveDuplicates {

	public static int[] removeDuplicates(int[] arr) {
		ArrayList<Integer> output = new ArrayList<Integer>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<arr.length; i++) {
			if(!map.containsKey(arr[i])) {
				output.add(arr[i]);
				map.put(arr[i], i);
			}else{
				int d = map.get(arr[i]) + 1;
				map.put(arr[i], d);
			}
		}
		int[] out = new int[output.size()];
		for(int i = 0; i<output.size(); i++) {
			out[i] = output.get(i);
		}
		Set<Integer> keys = map.keySet();
		for(int i: keys) {
			System.out.print(i +  " " + map.get(i) + " ");
		}
		System.out.println();
		return out;
	}
	
	public static void main(String[] args) {
		int[] arr  = {1, 3, 5, 2, 4, 1, 5, 6};
		arr = removeDuplicates(arr);
		for(int i: arr) {
			System.out.print(i + " ");
		}

	}

}
