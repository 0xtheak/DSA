package hashMap;

public class MapUse {

	public static void main(String[] args) {
		Map<Integer, Integer> map = new Map<>();
		map.insert(1, 2);
		map.insert(3, 2);
		map.insert(2, 2);
		map.insert(4, 2);
		map.insert(5, 2);
		map.insert(6, 2);


		System.out.println(map.size());
		System.out.println(map.loadFactor());
		System.out.println(map.getValue(20));

	}

}
