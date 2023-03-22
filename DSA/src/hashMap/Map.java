package hashMap;
import java.util.ArrayList;

public class Map<K,V> {
	ArrayList<Node<K,V>> buckets; 
	int count;
	int numBuckets;
	
	public Map() {
		buckets = new ArrayList<>();
		numBuckets = 20;
		for(int i =0; i<numBuckets; i++) {
			buckets.add(null);
		}
		count=0;
	}
	public int size() {
		return count;
	}
	private int getBucketIndex(K key) {
		int hc = key.hashCode();
		int index = hc% numBuckets;
		return index;
	}
	
	private void reHash() {
		ArrayList<Node<K,V>> temp = buckets;
		buckets = new ArrayList<>();
		numBuckets = 2 * numBuckets;
		for(int i=0; i<numBuckets ; i++) {
			buckets.add(null);
		}
		count = 0;
		for(int i=0; i<temp.size(); i++) {
			Node<K,V> head = temp.get(i);
			while(head!=null) {
				K key = head.key;;
				V value = head.value;
				insert(key, value);
				count++;
				head = head.next;
			}
		}
		
	}
	public double loadFactor() {
		return (1.0* count)/numBuckets;
	}
	public void insert(K key, V value) {
		int bucketIndex = getBucketIndex(key);
		Node<K,V> head = buckets.get(bucketIndex);
		while(head!=null) {
			if(head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}
		head = buckets.get(bucketIndex);
		Node<K,V> child = new Node<>(key, value);
		buckets.set(bucketIndex, child);
		count++;
		double lf = loadFactor(); 
		if(lf> 	0.7) {
			reHash();
		}
	
	}
	
	public V getValue(K key) {
		int bucketIndex = getBucketIndex(key);
		Node<K,V> head = buckets.get(bucketIndex);
		while(head!=null) {
			if(head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}
		return null;
	}
	
	
	public V removeKey(K key) {
		int bucketIndex = getBucketIndex(key);
		Node<K,V> head = buckets.get(bucketIndex);
		Node<K,V> previous=null;
		while(head!=null) {
			if(head.key.equals(key)) {
				if(previous == null) {
					buckets.set(bucketIndex, head.next);
				}else {
					previous.next = head.next;
				}
				count--;
				return head.value;
			} 
			previous = head;
			head = head.next;
		}
		return null;
	
	}
}
